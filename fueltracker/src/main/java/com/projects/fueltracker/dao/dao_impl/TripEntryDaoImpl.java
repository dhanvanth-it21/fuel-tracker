package com.projects.fueltracker.dao.dao_impl;

import com.projects.fueltracker.dao.TripEntryDao;
import com.projects.fueltracker.exception.ResourceNotFoundException;
import com.projects.fueltracker.model.collections.TripEntry;
import com.projects.fueltracker.service.TripEntryService;
import com.projects.fueltracker.template.TripEntryTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripEntryDaoImpl implements TripEntryDao {

    @Autowired
    private TripEntryTemplate tripEntryTemplate;

    @Override
    public TripEntry addTripEntry(TripEntry preSaveTripEntry) {
        return tripEntryTemplate.save(preSaveTripEntry);
    }

    @Override
    public TripEntry getById(String id) {
        TripEntry tripEntry = tripEntryTemplate.getById(id);
        if (tripEntry == null) {
            throw new ResourceNotFoundException("TripEntry with id: '" + id + "' not found");
        }
        return tripEntry;
    }

    @Override
    public TripEntry updateByID(TripEntry preSaveTripEntry) {
        String id = preSaveTripEntry.get_id();
        TripEntry existing = tripEntryTemplate.getById(id);
        if (existing == null) {
            throw new ResourceNotFoundException("TripEntry with id: '" + id + "' not found");
        }
        return tripEntryTemplate.save(preSaveTripEntry);
    }
}
