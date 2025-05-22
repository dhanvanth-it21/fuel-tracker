package com.projects.fueltracker.dao.dao_impl;

import com.projects.fueltracker.dao.FuelDao;
import com.projects.fueltracker.exception.ResourceNotFoundException;
import com.projects.fueltracker.model.collections.Fuel;
import com.projects.fueltracker.service.FuelService;
import com.projects.fueltracker.template.FuelTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuelDaoImpl implements FuelDao {

    @Autowired
    private FuelTemplate fuelTemplate;

    @Override
    public Fuel save(Fuel preSaveFuel) {
        return fuelTemplate.save(preSaveFuel);
    }

    @Override
    public Fuel getById(String id) {
        Fuel fuel =  fuelTemplate.getById(id);
        if(fuel == null) {
            throw new ResourceNotFoundException("Fuel with Id : '"+id+"' not found");
        }
        return fuel;
    }

    @Override
    public Fuel updateById(String id, Fuel preSaveFuel) {
        Fuel fuel =  fuelTemplate.getById(id);
        if(fuel == null) {
            throw new ResourceNotFoundException("Fuel with Id : '"+id+"' not found");
        }
        return fuelTemplate.save(preSaveFuel);
    }
}
