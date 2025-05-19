package com.projects.fueltracker.converter;

import com.projects.fueltracker.model.collections.Bunk;
import com.projects.fueltracker.model.dto.income.BunkDtoIncome;
import com.projects.fueltracker.model.dto.outgo.BunkDtoOutgo;
import com.projects.fueltracker.service.BunkService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BunkConverter {

    @Autowired
    private BunkService bunkService;

    @Autowired
    private ModelMapper modelMapper;

    public BunkDtoOutgo addBunk(BunkDtoIncome bunkDtoIncome) {
        //Dto to Entity
        Bunk preSaveBunk = modelMapper.map(bunkDtoIncome, Bunk.class);

        Bunk postSaveBunk = bunkService.addBunk(preSaveBunk);

        //Entity to Dto
        return modelMapper.map(postSaveBunk, BunkDtoOutgo.class);
    }

    public BunkDtoOutgo updateBunk(String id, BunkDtoIncome bunkDtoIncome) {
        //Dto to Entity
        Bunk  preSaveBunk = modelMapper.map(bunkDtoIncome, Bunk.class);
        preSaveBunk.set_id(id);

        Bunk postSaveBunk = bunkService.updateBunk(preSaveBunk);

        //Entity to Dto
        return modelMapper.map(postSaveBunk, BunkDtoOutgo.class);
    }

    public BunkDtoOutgo getBunkById(String id) {
        Bunk bunk = bunkService.getBunkById(id);

        //Entity to Dto
        return modelMapper.map(bunk, BunkDtoOutgo.class);
    }
}
