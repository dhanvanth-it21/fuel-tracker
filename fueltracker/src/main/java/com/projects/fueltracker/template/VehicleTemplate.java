package com.projects.fueltracker.template;

import com.projects.fueltracker.model.collections.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndReplaceOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.UpdateDefinition;
import org.springframework.stereotype.Repository;

@Repository
public class VehicleTemplate {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Vehicle save(Vehicle preSaveVehicle) {
        return mongoTemplate.save(preSaveVehicle);
    }

    public Vehicle getById(String id) {
        return mongoTemplate.findById(id, Vehicle.class);
    }

    public Vehicle update(String id, Vehicle preSaveVehicle) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.findAndReplace(query, preSaveVehicle, FindAndReplaceOptions.options().returnNew());
    }
}
