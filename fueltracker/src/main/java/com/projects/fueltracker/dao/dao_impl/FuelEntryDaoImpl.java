package com.projects.fueltracker.dao.dao_impl;

import com.projects.fueltracker.dao.FuelDao;
import com.projects.fueltracker.dao.FuelEntryDao;
import com.projects.fueltracker.exception.ResourceNotFoundException;
import com.projects.fueltracker.model.collections.FuelEntry;
import com.projects.fueltracker.template.FuelEntryTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuelEntryDaoImpl implements FuelEntryDao {

    @Autowired
    private FuelEntryTemplate fuelEntryTemplate;

    @Override
    public FuelEntry save(FuelEntry preSaveFuelEntry) {
        return fuelEntryTemplate.save(preSaveFuelEntry);
    }

    @Override
    public FuelEntry getById(String id) {
        FuelEntry fuelEntry = fuelEntryTemplate.getById(id);
        if (fuelEntry == null) {
            throw new ResourceNotFoundException("FuelEntry with Id : '" + id + "' not found");
        }
        return fuelEntry;
    }

    @Override
    public FuelEntry updateById(String id, FuelEntry preSaveFuelEntry) {
        FuelEntry fuelEntry = fuelEntryTemplate.getById(id);
        if (fuelEntry == null) {
            throw new ResourceNotFoundException("FuelEntry with Id : '" + id + "' not found");
        }
        return fuelEntryTemplate.save(preSaveFuelEntry);
    }
}
