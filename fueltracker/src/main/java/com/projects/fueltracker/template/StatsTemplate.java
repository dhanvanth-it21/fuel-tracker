package com.projects.fueltracker.template;

import com.projects.fueltracker.model.collections.Stats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class StatsTemplate {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void save(Stats stats) {
        mongoTemplate.save(stats);
    }

    public Stats findByVehicleId(String vehicleId) {
        Query query = new Query(Criteria.where("vehicleId").is(vehicleId));
        return mongoTemplate.findOne(query, Stats.class);
    }

    public void updateByVehicleId(String vehicleId, Stats updatedStats) {
        Query query = new Query(Criteria.where("vehicleId").is(vehicleId));
        Update update = new Update();

        if (updatedStats.getFuelUsageByType() != null) {
            update.set("fuelUsageByType", updatedStats.getFuelUsageByType());
        }

        mongoTemplate.updateFirst(query, update, Stats.class);
    }
}
