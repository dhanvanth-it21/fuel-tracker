package com.projects.fueltracker.dao.dao_impl;

import com.projects.fueltracker.dao.LabelDao;
import com.projects.fueltracker.exception.ResourceNotFoundException;
import com.projects.fueltracker.model.collections.Label;
import com.projects.fueltracker.template.LabelTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabelDaoImpl implements LabelDao {

    @Autowired
    private LabelTemplate labelTemplate;

    @Override
    public Label addLabel(Label preSaveLabel) {
        return labelTemplate.save(preSaveLabel);
    }

    @Override
    public Label getById(String id) {
        Label label = labelTemplate.getById(id);
        if (label == null) {
            throw new ResourceNotFoundException("Label with id: '" + id + "' not found");
        }
        return label;
    }

    @Override
    public Label updateByID(Label preSaveLabel) {
        String id = preSaveLabel.get_id();
        Label existing = labelTemplate.getById(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Label with id: '" + id + "' not found");
        }
        return labelTemplate.save(preSaveLabel);
    }
}
