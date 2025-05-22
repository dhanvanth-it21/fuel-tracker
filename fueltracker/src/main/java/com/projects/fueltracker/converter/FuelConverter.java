package com.projects.fueltracker.converter;

import com.projects.fueltracker.model.collections.Fuel;
import com.projects.fueltracker.model.dto.income.FuelDtoIncome;
import com.projects.fueltracker.model.dto.outgo.FuelDtoOutgo;
import com.projects.fueltracker.service.FuelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuelConverter {

    @Autowired
    private FuelService fuelService;

    @Autowired
    private ModelMapper modelMapper;

    public FuelDtoOutgo addFuel(FuelDtoIncome fuelDtoIncome) {
        //Dto to Entity
        Fuel preSaveFuel = modelMapper.map(fuelDtoIncome, Fuel.class);

        Fuel postSaveFuel = fuelService.save(preSaveFuel);

        //Dto to Entity
        return modelMapper.map(postSaveFuel, FuelDtoOutgo.class);
    }

    public FuelDtoOutgo getFuelById(String id) {
        Fuel fuel = fuelService.getFuelById(id);
        return modelMapper.map(fuel, FuelDtoOutgo.class);
    }

    public FuelDtoOutgo updateFuelById(String id, FuelDtoIncome fuelDtoIncome) {
        //Dto to Entity
        Fuel preSaveFuel = modelMapper.map(fuelDtoIncome, Fuel.class);
        preSaveFuel.set_id(id);

        Fuel postFuelSave = fuelService.updateFuelById(id, preSaveFuel);

        //Entity to Dto
        return modelMapper.map(postFuelSave, FuelDtoOutgo.class);

    }
}
