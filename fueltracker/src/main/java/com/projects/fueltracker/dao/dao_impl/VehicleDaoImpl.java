package com.projects.fueltracker.dao.dao_impl;

import com.projects.fueltracker.dao.VehicleDao;
import com.projects.fueltracker.exception.ResourceNotFoundException;
import com.projects.fueltracker.model.collections.Vehicle;
import com.projects.fueltracker.template.VehicleTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleDaoImpl implements VehicleDao {

    @Autowired
    private VehicleTemplate vehicleTemplate;

    @Override
    public Vehicle addVehicle(Vehicle preSaveVehicle) {
        return vehicleTemplate.save(preSaveVehicle);
    }

    @Override
    public Vehicle getById(String id) {
        Vehicle vehicle =  vehicleTemplate.getById(id);
        if(vehicle == null) {
            throw new ResourceNotFoundException("Vehicle with id : '"+id+"' not found");
        }
        return vehicle;
    }

    @Override
    public Vehicle updateByID(String id, Vehicle preSaveVehicle) {
        Vehicle vehicle =  vehicleTemplate.getById(id);
        if(vehicle == null) {
            throw new ResourceNotFoundException("Vehicle with id : '"+id+"' not found");
        }
        return vehicleTemplate.update(id, preSaveVehicle);
    }
}
