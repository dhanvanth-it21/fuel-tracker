package com.projects.fueltracker.service;


import com.projects.fueltracker.dao.FuelDao;
import com.projects.fueltracker.dao.FuelEntryDao;
import com.projects.fueltracker.dao.StatsDao;
import com.projects.fueltracker.dao.VehicleDao;
import com.projects.fueltracker.exception.ResourceAlreadyExists;
import com.projects.fueltracker.model.collections.FuelEntry;
import com.projects.fueltracker.model.collections.FuelStats;
import com.projects.fueltracker.model.collections.Stats;
import com.projects.fueltracker.model.collections.Vehicle;
import com.projects.fueltracker.model.dto.outgo.FuelEntryDtoOutgo;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Log4j2
public class FuelEntryService {

    @Autowired
    private FuelEntryDao fuelEntryDao;

    @Autowired
    private VehicleDao vehicleDao;

    @Autowired
    private FuelDao fuelDao;

    @Autowired
    private StatsService statsService;

    @Autowired
    private ModelMapper modelMapper;

    public FuelEntry save(FuelEntry preSaveFuelEntry) {
        log.info("[SAVE] Adding new FuelEntry - Start");

        // Check for duplicates
        checkAndThrowIfDuplicate(preSaveFuelEntry);

        // Check for fuel present in that ID
        checkForFuelPresent(preSaveFuelEntry.getFuelId());

        // Fetch associated vehicle
        String vehicleId = preSaveFuelEntry.getVehicleId();
        Vehicle vehicle = vehicleDao.getById(vehicleId);

        // Update odometer if needed
        updateVehicleOdometerIfNeeded(vehicle, preSaveFuelEntry.getOdometerReading());

        // Update fuel usage stats
        statsService.updateFuelStatsOnNewEntry(vehicle.get_id(), preSaveFuelEntry);

        // Save updated vehicle
        vehicleDao.updateByID(vehicleId, vehicle);

        // Save fuel entry
        FuelEntry fuelEntry = fuelEntryDao.save(preSaveFuelEntry);

        log.info("[SAVE] FuelEntry saved successfully for vehicleId: {}", vehicleId);
        return fuelEntry;
    }

    public FuelEntry getFuelEntryById(String id) {
        log.info("Fetching FuelEntry, In Progress");

        FuelEntry fuelEntry = fuelEntryDao.getById(id);

        log.info("Fetching FuelEntry, Completed");
        return fuelEntry;
    }

    public FuelEntry updateFuelEntryById(String id, FuelEntry preSaveFuelEntry) {
        log.info("Updating FuelEntry, In Progress");

        FuelEntry fuelEntry = fuelEntryDao.updateById(id, preSaveFuelEntry);

        log.info("Updating FuelEntry, Completed");
        return fuelEntry;
    }

    //Helper functionalities-------------------------------

    private FuelEntry checkForDuplication(FuelEntry preSaveFuelEntry) {
        //this is based on the vehicleId, fueledDate, odometerReading
        log.info("Checking for the duplicate entry, In Progress");
        FuelEntry fuelEntry = fuelEntryDao.checkForDuplication(preSaveFuelEntry);
        log.info("Checking for the duplicate entry, Completed");
        return fuelEntry;
    }

    private void checkAndThrowIfDuplicate(FuelEntry fuelEntry) {
        FuelEntry duplicate = checkForDuplication(fuelEntry);
        if (duplicate != null) {
            String message = "Fuel entry already exists for this vehicle with the same details.";
            log.warn("[SAVE] Duplicate FuelEntry found for vehicleId: {}", fuelEntry.getVehicleId());
            throw new ResourceAlreadyExists(message, modelMapper.map(duplicate, FuelEntryDtoOutgo.class));
        }
    }

    private void updateVehicleOdometerIfNeeded(Vehicle vehicle, float newOdometerReading) {
        if (newOdometerReading > vehicle.getOdometerReading()) {
            log.info("[ODOMETER] Updating odometer from {} to {}", vehicle.getOdometerReading(), newOdometerReading);
            vehicle.setOdometerReading(newOdometerReading);
        }
    }

    private void checkForFuelPresent(String fuelId) {
        fuelDao.getById(fuelId);
    }

}
