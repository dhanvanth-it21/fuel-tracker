package com.projects.fueltracker.service;


import com.projects.fueltracker.dao.FuelEntryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuelEntryService {

    @Autowired
    private FuelEntryDao fuelEntryDao;
}
