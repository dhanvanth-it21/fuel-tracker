package com.projects.fueltracker.template;

import com.projects.fueltracker.model.collections.BunkBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BunkBrandTemplate {

    @Autowired
    private MongoTemplate mongoTemplate;

    public BunkBrand save(BunkBrand bunkBrandPreSave) {
        return mongoTemplate.save(bunkBrandPreSave);
    }
}
