package com.projects.fueltracker.dao.dao_impl;

import com.projects.fueltracker.dao.TripEntryDao;
import com.projects.fueltracker.service.TripEntryService;
import com.projects.fueltracker.template.TripEntryTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripEntryDaoImpl implements TripEntryDao {

    @Autowired
    private TripEntryTemplate tripEntryTemplate;
}
