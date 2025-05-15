package com.projects.fueltracker.converter;

import com.projects.fueltracker.service.LabelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabelConverter {

    @Autowired
    private LabelService labelService;

    @Autowired
    private ModelMapper modelMapper;
}
