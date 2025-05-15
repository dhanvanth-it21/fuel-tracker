package com.projects.fueltracker.dao;

import com.projects.fueltracker.model.collections.BunkBrand;
import org.springframework.stereotype.Service;

@Service
public interface BunkBrandDao {


    BunkBrand save(BunkBrand bunkBrandPreSave);

    BunkBrand getByName(String name);

    BunkBrand getById(String id);
}
