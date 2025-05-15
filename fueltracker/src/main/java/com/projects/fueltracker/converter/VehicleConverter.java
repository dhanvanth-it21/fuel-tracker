package com.projects.fueltracker.converter;

import com.projects.fueltracker.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleConverter {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private ModelMapper modelMapper;
}
