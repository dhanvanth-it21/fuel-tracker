package com.projects.fueltracker.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VehicleTemplate {

    @Autowired
    private MongoTemplate mongoTemplate;
}
