package com.projects.fueltracker.converter;

import com.projects.fueltracker.service.TripEntryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripEntryConverter {

    @Autowired
    private TripEntryService tripEntryService;

    @Autowired
    private ModelMapper modelMapper;
}
