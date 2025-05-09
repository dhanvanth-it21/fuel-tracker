package com.projects.fueltracker.dao.dao_impl;

import com.projects.fueltracker.dao.LabelDao;
import com.projects.fueltracker.template.LabelTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabelDaoImpl implements LabelDao {

    @Autowired
    private LabelTemplate labelTemplate;
}
