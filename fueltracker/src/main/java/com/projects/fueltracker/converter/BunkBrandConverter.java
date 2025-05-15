package com.projects.fueltracker.converter;

import com.projects.fueltracker.model.collections.BunkBrand;
import com.projects.fueltracker.model.dto.income.BunkBrandDtoIncome;
import com.projects.fueltracker.model.dto.outgo.BunkBrandDtoOutgo;
import com.projects.fueltracker.service.BunkBrandService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BunkBrandConverter {

    @Autowired
    private BunkBrandService bunkBrandService;

    @Autowired
    private ModelMapper modelMapper;

    public BunkBrandDtoOutgo createBunkBrand(@Valid BunkBrandDtoIncome bunkBrandDtoIncome) {
        //Dto to Entity
        BunkBrand preBunkBrand = modelMapper.map(bunkBrandDtoIncome, BunkBrand.class);

        BunkBrand result = bunkBrandService.createBunkBrand(preBunkBrand);

        //Entity to Dto
        BunkBrandDtoOutgo bunkBrandDtoOutgo = modelMapper.map(result, BunkBrandDtoOutgo.class);
        return bunkBrandDtoOutgo;
    }

    public BunkBrandDtoOutgo getBunkBrandById(String id) {

        BunkBrand bunkBrand = bunkBrandService.getBunkBrandById(id);

        //Entity to Dto
        return modelMapper.map(bunkBrand, BunkBrandDtoOutgo.class);
    }

    public BunkBrandDtoOutgo updateBunkBrand(String id, BunkBrandDtoIncome bunkBrandDtoIncome) {
        //Dto to Entity
        BunkBrand preBunkBrand = modelMapper.map(bunkBrandDtoIncome, BunkBrand.class);
        preBunkBrand.set_id(id);

        BunkBrand postBunkBrand = bunkBrandService.updateBunkBrandById(preBunkBrand);

        //Entity to Dto
        return modelMapper.map(postBunkBrand, BunkBrandDtoOutgo.class);
    }


    public BunkBrandDtoOutgo changeActiveStatus(String id, Boolean activeStatus) {
        BunkBrand bunkBrand = bunkBrandService.changeActiveStatus(id, activeStatus);
        if(bunkBrand == null) return null;
        //Entity to Dto
        return modelMapper.map(bunkBrand, BunkBrandDtoOutgo.class);
    }
}
