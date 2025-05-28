package com.projects.fueltracker.dao;

import com.projects.fueltracker.model.collections.Stats;
import org.springframework.stereotype.Service;

@Service
public interface StatsDao {
    void save(Stats stats);

    Stats getByVehicleId(String vehicleId);

    void updateByVehicleId(String vehicleId, Stats stats);
}
