package com.projects.fueltracker.converter;

import com.projects.fueltracker.model.collections.FuelEntry;
import com.projects.fueltracker.model.dto.income.FuelEntryDtoIncome;
import com.projects.fueltracker.model.dto.outgo.FuelEntryDtoOutgo;
import com.projects.fueltracker.service.FuelEntryService;
import com.projects.fueltracker.utils.DateTimeUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Log4j2
public class FuelEntryConverter {

    @Autowired
    private FuelEntryService fuelEntryService;

    @Autowired
    private ModelMapper modelMapper;

//    Here Incoming Dto has the fueledDateInMilli,
//    this is converted to the ISO date format and
//    vice versa in the response process
    public FuelEntryDtoOutgo addFuelEntry(FuelEntryDtoIncome fuelEntryDtoIncome) {
        // Dto to Entity
        FuelEntry preSaveFuelEntry = modelMapper.map(fuelEntryDtoIncome, FuelEntry.class);
        Date date = DateTimeUtil.millisToIsoDate(fuelEntryDtoIncome.getFueledDateInMilli());
        preSaveFuelEntry.setFueledDate(date);

        FuelEntry postSaveFuelEntry = fuelEntryService.save(preSaveFuelEntry);

        FuelEntryDtoOutgo fuelEntryDtoOutgo = modelMapper.map(postSaveFuelEntry, FuelEntryDtoOutgo.class);
        long milli = DateTimeUtil.isoDateToMillis(postSaveFuelEntry.getFueledDate());
        fuelEntryDtoOutgo.setFueledDateInMilli(milli);
        // Entity to Dto
        return fuelEntryDtoOutgo;
    }

    public FuelEntryDtoOutgo getFuelEntryById(String id) {
        FuelEntry fuelEntry = fuelEntryService.getFuelEntryById(id);
        FuelEntryDtoOutgo fuelEntryDtoOutgo = modelMapper.map(fuelEntry, FuelEntryDtoOutgo.class);
        long milli = DateTimeUtil.isoDateToMillis(fuelEntry.getFueledDate());
        fuelEntryDtoOutgo.setFueledDateInMilli(milli);
        return fuelEntryDtoOutgo;
    }

    public FuelEntryDtoOutgo updateFuelEntryById(String id, FuelEntryDtoIncome fuelEntryDtoIncome) {
        // Dto to Entity
        FuelEntry preSaveFuelEntry = fuelEntryService.getFuelEntryById(id);
        modelMapper.map(fuelEntryDtoIncome, preSaveFuelEntry);
        Date date = DateTimeUtil.millisToIsoDate(fuelEntryDtoIncome.getFueledDateInMilli());
        preSaveFuelEntry.setFueledDate(date);
        preSaveFuelEntry.set_id(id);

        FuelEntry postSaveFuelEntry = fuelEntryService.updateFuelEntryById(id, preSaveFuelEntry);

        FuelEntryDtoOutgo fuelEntryDtoOutgo = modelMapper.map(postSaveFuelEntry, FuelEntryDtoOutgo.class);
        long milli = DateTimeUtil.isoDateToMillis(postSaveFuelEntry.getFueledDate());
        fuelEntryDtoOutgo.setFueledDateInMilli(milli);
        // Entity to Dto
        return fuelEntryDtoOutgo;
    }
}
