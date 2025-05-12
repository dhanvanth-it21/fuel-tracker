package com.projects.fueltracker.service;

import com.projects.fueltracker.dao.BunkBrandDao;
import com.projects.fueltracker.exception.BunkBrandAlreadyExistsException;
import com.projects.fueltracker.exception.BunkBrandNotFoundException;
import com.projects.fueltracker.model.collections.BunkBrand;
import com.projects.fueltracker.model.dto.income.BunkBrandDtoIncome;
import com.projects.fueltracker.model.dto.outgo.BunkBrandDtoOutgo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
public class BunkBrandService {

    @Autowired
    private BunkBrandDao bunkBrandDao;

    @Autowired
    private ModelMapper modelMapper;


    // creating and saving the BunkBrand
    public BunkBrandDtoOutgo createBunkBrand(BunkBrandDtoIncome bunkBrandDtoIncome) {
        String name = bunkBrandDtoIncome.getName();
        BunkBrand bunkBrandPreSave = null;
        //check already exist in DB
        boolean alreadyExists = checkBunkBrandNameAldredyExists(name);
        //save to DB
        if(!alreadyExists) {
            bunkBrandPreSave = modelMapper.map(bunkBrandDtoIncome, BunkBrand.class);
        }
        else {
            throw new BunkBrandAlreadyExistsException("Bunk Brand '"+name+ "' Already Exists");
        }
        BunkBrand bunkBrandPostSave =  bunkBrandDao.save(bunkBrandPreSave);
        BunkBrandDtoOutgo bunkBrandDtoOutgo = modelMapper.map(bunkBrandPostSave, BunkBrandDtoOutgo.class);
        return bunkBrandDtoOutgo;
    }

    public BunkBrandDtoOutgo getBunkBrandById(String id) {
        return null;
    }

//    ---------------------------------------------------------------------------------------------------------
    //Helper functions :
    private boolean checkBunkBrandNameAldredyExists(String name) {
        return false;
    }
}

