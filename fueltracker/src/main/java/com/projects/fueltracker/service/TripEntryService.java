package com.projects.fueltracker.service;

import com.projects.fueltracker.dao.TripEntryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripEntryService {

    @Autowired
    private TripEntryDao tripEntryDao;
}
