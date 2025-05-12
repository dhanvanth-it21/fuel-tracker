package com.projects.fueltracker.controller;

import com.projects.fueltracker.service.BunkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping
    public void updateBunk() {}

    //Read

    @GetMapping
    public void getBunk() {}

    //Delete

    @DeleteMapping
    public void deleteBunk() {}

}
