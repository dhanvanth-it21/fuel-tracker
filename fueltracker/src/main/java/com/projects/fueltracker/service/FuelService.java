package com.projects.fueltracker.service;

import com.projects.fueltracker.dao.FuelDao;
import com.projects.fueltracker.model.collections.Fuel;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class FuelService {

    @Autowired
    private FuelDao fuelDao;

    public Fuel save(Fuel preSaveFuel) {
        log.info("Adding new Bunk, In Progress");

        Fuel fuel = fuelDao.save(preSaveFuel);

        log.info("Adding new Bunk, Completed");
        return fuel;

    }

    public Fuel getFuelById(String id) {
        log.info("Fetching Bunk, In Progress");

        Fuel fuel = fuelDao.getById(id);

        log.info("Fetching Bunk, Completed");
        return fuel;
    }

    public Fuel updateFuelById(String id, Fuel preSaveFuel) {
        log.info("Updating Bunk, In Progress");

        Fuel fuel = fuelDao.updateById(id, preSaveFuel);

        log.info("Updating Bunk, Completed");
        return fuel;
    }
}
