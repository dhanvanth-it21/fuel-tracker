package com.projects.fueltracker.dao;

import com.projects.fueltracker.model.collections.FuelEntry;
import org.springframework.stereotype.Service;

@Service
public interface FuelEntryDao {
    FuelEntry save(FuelEntry preSaveFuelEntry);

    FuelEntry getById(String id);

    FuelEntry updateById(String id, FuelEntry preSaveFuelEntry);
}
