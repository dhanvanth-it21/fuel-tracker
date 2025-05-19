package com.projects.fueltracker.template;

import com.projects.fueltracker.model.collections.Bunk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class BunkTemplate {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Bunk save(Bunk bunk) {
        return mongoTemplate.save(bunk);
    }

    public Bunk getById(String id) {
        return mongoTemplate.findById(id, Bunk.class);
    }

    public Bunk updateById(Bunk preSaveBunk) {

        Query query = new Query(Criteria.where("_id").is(preSaveBunk.get_id()));
        return mongoTemplate.findAndReplace(query, preSaveBunk);

    }
}
