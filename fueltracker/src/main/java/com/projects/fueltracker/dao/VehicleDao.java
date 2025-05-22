package com.projects.fueltracker.dao;

import com.projects.fueltracker.model.collections.Vehicle;
import org.springframework.stereotype.Service;

@Service
public interface VehicleDao {
    Vehicle addVehicle(Vehicle preSaveVehicle);

    Vehicle getById(String id);

    Vehicle updateByID(String id, Vehicle preSaveVehicle);
}
