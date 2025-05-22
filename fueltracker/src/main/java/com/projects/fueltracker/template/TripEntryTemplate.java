package com.projects.fueltracker.template;

import com.projects.fueltracker.model.collections.TripEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TripEntryTemplate {

    @Autowired
    private MongoTemplate mongoTemplate;

    public TripEntry save(TripEntry preSaveTripEntry) {
        return mongoTemplate.save(preSaveTripEntry);
    }

    public TripEntry getById(String id) {
        return mongoTemplate.findById(id, TripEntry.class);
    }

}
