package com.projects.fueltracker.template;

import com.projects.fueltracker.model.collections.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LabelTemplate {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Label save(Label preSaveLabel) {
        return mongoTemplate.save(preSaveLabel);
    }

    public Label getById(String id) {
        return mongoTemplate.findById(id, Label.class);
    }
}
