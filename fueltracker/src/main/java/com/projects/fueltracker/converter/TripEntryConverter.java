package com.projects.fueltracker.converter;

import com.projects.fueltracker.model.collections.TripEntry;
import com.projects.fueltracker.model.dto.income.TripEntryDtoIncome;
import com.projects.fueltracker.model.dto.outgo.TripEntryDtoOutgo;
import com.projects.fueltracker.service.TripEntryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripEntryConverter {

    @Autowired
    private TripEntryService tripEntryService;

    @Autowired
    private ModelMapper modelMapper;

    public TripEntryDtoOutgo addTripEntry(TripEntryDtoIncome tripEntryDtoIncome) {
        // Dto to Entity
        TripEntry preSaveTripEntry = modelMapper.map(tripEntryDtoIncome, TripEntry.class);

        TripEntry postSaveTripEntry = tripEntryService.addTripEntry(preSaveTripEntry);

        // Entity to Dto
        return modelMapper.map(postSaveTripEntry, TripEntryDtoOutgo.class);
    }

    public TripEntryDtoOutgo getTripEntryById(String id) {
        TripEntry tripEntry = tripEntryService.getTripEntryById(id);

        // Entity to Dto
        return modelMapper.map(tripEntry, TripEntryDtoOutgo.class);
    }

    public TripEntryDtoOutgo updateTripEntryById(String id, TripEntryDtoIncome tripEntryDtoIncome) {
        // Dto to Entity
        TripEntry preSaveTripEntry = modelMapper.map(tripEntryDtoIncome, TripEntry.class);
        preSaveTripEntry.set_id(id);

        TripEntry postSaveTripEntry = tripEntryService.updateTripEntryById(preSaveTripEntry);

        // Entity to Dto
        return modelMapper.map(postSaveTripEntry, TripEntryDtoOutgo.class);
    }
}
