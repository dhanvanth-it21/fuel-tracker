package com.projects.fueltracker.dao;

import com.projects.fueltracker.model.collections.TripEntry;
import org.springframework.stereotype.Service;

@Service
public interface TripEntryDao {
    TripEntry addTripEntry(TripEntry preSaveTripEntry);

    TripEntry getById(String id);

    TripEntry updateByID(TripEntry preSaveTripEntry);
}
