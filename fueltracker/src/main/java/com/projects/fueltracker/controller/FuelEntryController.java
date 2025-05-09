package com.projects.fueltracker.controller;

import com.projects.fueltracker.service.FuelEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/fuel-entry")
public class FuelEntryController {

    @Autowired
    private FuelEntryService fuelEntryService;
}
