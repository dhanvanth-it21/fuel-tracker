package com.projects.fueltracker.controller;

import com.projects.fueltracker.service.BunkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/bunk")
public class BunkController {

    @Autowired
    private BunkService bunkService;

    //Create

    @PostMapping
    public void addNewBunk() {}

    //Update

    //Read

    //Delete

}
