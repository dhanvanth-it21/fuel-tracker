package com.projects.fueltracker.converter;

import com.projects.fueltracker.service.StatsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsConverter {

    @Autowired
    private StatsService statsService;

    @Autowired
    private ModelMapper modelMapper;
}
