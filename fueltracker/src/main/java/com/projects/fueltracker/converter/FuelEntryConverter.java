package com.projects.fueltracker.converter;

import com.projects.fueltracker.model.collections.FuelEntry;
import com.projects.fueltracker.model.dto.income.FuelEntryDtoIncome;
import com.projects.fueltracker.model.dto.outgo.FuelEntryDtoOutgo;
import com.projects.fueltracker.service.FuelEntryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuelEntryConverter {

    @Autowired
    private FuelEntryService fuelEntryService;

    @Autowired
    private ModelMapper modelMapper;

    public FuelEntryDtoOutgo addFuelEntry(FuelEntryDtoIncome fuelEntryDtoIncome) {
        // Dto to Entity
        FuelEntry preSaveFuelEntry = modelMapper.map(fuelEntryDtoIncome, FuelEntry.class);

        FuelEntry postSaveFuelEntry = fuelEntryService.save(preSaveFuelEntry);

        // Entity to Dto
        return modelMapper.map(postSaveFuelEntry, FuelEntryDtoOutgo.class);
    }

    public FuelEntryDtoOutgo getFuelEntryById(String id) {
        FuelEntry fuelEntry = fuelEntryService.getFuelEntryById(id);
        return modelMapper.map(fuelEntry, FuelEntryDtoOutgo.class);
    }

    public FuelEntryDtoOutgo updateFuelEntryById(String id, FuelEntryDtoIncome fuelEntryDtoIncome) {
        // Dto to Entity
        FuelEntry preSaveFuelEntry = fuelEntryService.getFuelEntryById(id);
        modelMapper.map(fuelEntryDtoIncome, preSaveFuelEntry);
        preSaveFuelEntry.set_id(id);

        FuelEntry postSaveFuelEntry = fuelEntryService.updateFuelEntryById(id, preSaveFuelEntry);

        // Entity to Dto
        return modelMapper.map(postSaveFuelEntry, FuelEntryDtoOutgo.class);
    }
}
