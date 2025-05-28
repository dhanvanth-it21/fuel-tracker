package com.projects.fueltracker.template;

import com.projects.fueltracker.model.collections.FuelEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Date;

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

    public FuelEntry checkForDuplication(FuelEntry preSaveFuelEntry) {
        String vehicleId = preSaveFuelEntry.getVehicleId();
        float odometerReading = preSaveFuelEntry.getOdometerReading();
        Date fueledDate = preSaveFuelEntry.getFueledDate();

        // Calculate start and end of day
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fueledDate);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date startOfDay = calendar.getTime();

        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date endOfDay = calendar.getTime();

        // Build query
        Query query = new Query();
        query.addCriteria(Criteria.where("vehicleId").is(vehicleId));
        query.addCriteria(Criteria.where("fueledDate").gte(startOfDay).lt(endOfDay));
        query.addCriteria(Criteria.where("odometerReading").is(odometerReading));

        return mongoTemplate.findOne(query, FuelEntry.class);
    }
}
