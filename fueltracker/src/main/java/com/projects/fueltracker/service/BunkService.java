package com.projects.fueltracker.service;

import com.projects.fueltracker.dao.BunkDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BunkService {

    @Autowired
    private BunkDao bunkDao;
}
