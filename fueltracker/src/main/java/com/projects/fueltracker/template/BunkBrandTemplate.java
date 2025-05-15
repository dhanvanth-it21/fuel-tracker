package com.projects.fueltracker.template;

import com.projects.fueltracker.model.collections.BunkBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class BunkBrandTemplate {

    @Autowired
    private MongoTemplate mongoTemplate;

    public BunkBrand save(BunkBrand bunkBrandPreSave) {
        return mongoTemplate.save(bunkBrandPreSave);
    }

    public BunkBrand getByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));

        return mongoTemplate.findOne(query, BunkBrand.class);
    }

    public BunkBrand getById(String id) {
        return mongoTemplate.findById(id, BunkBrand.class);
    }
}
