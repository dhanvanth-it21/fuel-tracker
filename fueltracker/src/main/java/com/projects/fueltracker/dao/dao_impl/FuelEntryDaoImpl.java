package com.projects.fueltracker.dao.dao_impl;

import com.projects.fueltracker.dao.FuelDao;
import com.projects.fueltracker.dao.FuelEntryDao;
import com.projects.fueltracker.template.FuelEntryTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuelEntryDaoImpl implements FuelEntryDao {

    @Autowired
    private FuelEntryTemplate fuelEntryTemplate;
}
