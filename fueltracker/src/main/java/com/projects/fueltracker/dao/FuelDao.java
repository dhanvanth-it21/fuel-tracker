package com.projects.fueltracker.dao;

import com.projects.fueltracker.model.collections.Fuel;
import org.springframework.stereotype.Service;

@Service
public interface FuelDao {
    Fuel save(Fuel preSaveFuel);

    Fuel getById(String id);

    Fuel updateById(String id, Fuel preSaveFuel);
}
