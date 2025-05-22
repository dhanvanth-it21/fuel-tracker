package com.projects.fueltracker.service;

import com.projects.fueltracker.dao.TripEntryDao;
import com.projects.fueltracker.model.collections.TripEntry;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class TripEntryService {

    @Autowired
    private TripEntryDao tripEntryDao;

    public TripEntry addTripEntry(TripEntry preSaveTripEntry) {
        log.info("Creating TripEntry, In Progress");

        TripEntry tripEntry = tripEntryDao.addTripEntry(preSaveTripEntry);

        log.info("Creating TripEntry, Completed");
        return tripEntry;
    }

    public TripEntry getTripEntryById(String id) {
        log.info("Fetching TripEntry, In Progress");

        TripEntry tripEntry = tripEntryDao.getById(id);

        log.info("Fetching TripEntry, Completed");
        return tripEntry;
    }

    public TripEntry updateTripEntryById(TripEntry preSaveTripEntry) {
        log.info("Updating TripEntry, In Progress");

        TripEntry tripEntry = tripEntryDao.updateByID(preSaveTripEntry);

        log.info("Updating TripEntry, Completed");
        return tripEntry;
    }
}
