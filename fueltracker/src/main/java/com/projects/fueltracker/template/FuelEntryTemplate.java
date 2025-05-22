package com.projects.fueltracker.template;

import com.projects.fueltracker.model.collections.FuelEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FuelEntryTemplate {

    @Autowired
    private MongoTemplate mongoTemplate;

    public FuelEntry save(FuelEntry preSaveFuelEntry) {
        return mongoTemplate.save(preSaveFuelEntry);
    }

    public FuelEntry getById(String id) {
        return mongoTemplate.findById(id, FuelEntry.class);
    }
}
