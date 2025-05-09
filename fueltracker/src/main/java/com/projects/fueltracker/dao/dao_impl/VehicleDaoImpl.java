package com.projects.fueltracker.dao.dao_impl;

import com.projects.fueltracker.dao.VehicleDao;
import com.projects.fueltracker.template.VehicleTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleDaoImpl implements VehicleDao {

    @Autowired
    private VehicleTemplate vehicleTemplate;
}
