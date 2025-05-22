package com.projects.fueltracker.dao;

import com.projects.fueltracker.model.collections.Label;
import org.springframework.stereotype.Service;

@Service
public interface LabelDao {
    Label addLabel(Label preSaveLabel);

    Label getById(String id);

    Label updateByID(Label preSaveLabel);
}
