package com.projects.fueltracker.dao.dao_impl;

import com.projects.fueltracker.dao.BunkDao;
import com.projects.fueltracker.template.BunkTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BunkDaoImpl implements BunkDao {

    @Autowired
    private BunkTemplate bunkTemplate;

}
