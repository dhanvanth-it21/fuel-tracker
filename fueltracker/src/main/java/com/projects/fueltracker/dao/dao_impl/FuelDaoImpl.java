package com.projects.fueltracker.dao.dao_impl;

import com.projects.fueltracker.dao.FuelDao;
import com.projects.fueltracker.service.FuelService;
import com.projects.fueltracker.template.FuelTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuelDaoImpl implements FuelDao {

    @Autowired
    private FuelTemplate fuelTemplate;
}
