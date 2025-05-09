package com.projects.fueltracker.service;

import com.projects.fueltracker.dao.LabelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabelService {

    @Autowired
    private LabelDao labelDao;
}
