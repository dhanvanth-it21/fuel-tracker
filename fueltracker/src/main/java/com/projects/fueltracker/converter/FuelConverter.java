package com.projects.fueltracker.converter;

import com.projects.fueltracker.service.FuelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuelConverter {

    @Autowired
    private FuelService fuelService;

    @Autowired
    private ModelMapper modelMapper;
}
