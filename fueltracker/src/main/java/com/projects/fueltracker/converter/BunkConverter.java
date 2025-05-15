package com.projects.fueltracker.converter;

import com.projects.fueltracker.service.BunkService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BunkConverter {

    @Autowired
    private BunkService bunkService;

    @Autowired
    private ModelMapper modelMapper;
}
