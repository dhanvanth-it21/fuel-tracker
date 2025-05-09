package com.projects.fueltracker.service;

import com.projects.fueltracker.dao.FuelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuelService {

    @Autowired
    private FuelDao fuelDao;
}
