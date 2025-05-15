package com.projects.fueltracker.converter;

import com.projects.fueltracker.service.FuelEntryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuelEntryConverter {

    @Autowired
    private FuelEntryService fuelEntryService;

    @Autowired
    private ModelMapper modelMapper;
}
