package com.projects.fueltracker.template;

import com.projects.fueltracker.model.collections.Fuel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class FuelTemplate {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Fuel save(Fuel preSaveFuel) {
        return mongoTemplate.save(preSaveFuel);
    }

    public Fuel getById(String id) {
        return mongoTemplate.findById(id, Fuel.class);
    }

}
