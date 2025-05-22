package com.projects.fueltracker.service;


import com.projects.fueltracker.dao.FuelEntryDao;
import com.projects.fueltracker.model.collections.FuelEntry;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class FuelEntryService {

    @Autowired
    private FuelEntryDao fuelEntryDao;

    public FuelEntry save(FuelEntry preSaveFuelEntry) {
        log.info("Adding new FuelEntry, In Progress");

        FuelEntry fuelEntry = fuelEntryDao.save(preSaveFuelEntry);

        log.info("Adding new FuelEntry, Completed");
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
}
