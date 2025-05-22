package com.projects.fueltracker.service;

import com.projects.fueltracker.dao.VehicleDao;
import com.projects.fueltracker.model.collections.Vehicle;
import com.projects.fueltracker.model.dto.income.VehicleDtoIncome;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class VehicleService {

    @Autowired
    private VehicleDao vehicleDao;

    public Vehicle addVehicle(Vehicle preSaveVehicle) {
        log.info("Creating Vehicle, In Progress");

        Vehicle vehicle =  vehicleDao.addVehicle(preSaveVehicle);

        log.info("Creating Vechile, Completed");
        return vehicle;
    }

    public Vehicle getVehicleById(String id) {
        log.info("Fetching the Vehicle, In Progress");

        Vehicle vehicle = vehicleDao.getById(id);

        log.info("Fetching the vehicle, Completed");
        return vehicle;
    }

    public Vehicle updateVehilceById(String id, Vehicle preSaveVehicle) {
        log.info("Updating the Vehicle, In Progress");

        Vehicle vehicle = vehicleDao.updateByID(id, preSaveVehicle);

        log.info("Updating the vehicle, Completed");
        return vehicle;
    }
}
