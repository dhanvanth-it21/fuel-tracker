package com.projects.fueltracker.dao.dao_impl;

import com.projects.fueltracker.dao.BunkBrandDao;
import com.projects.fueltracker.model.collections.BunkBrand;
import com.projects.fueltracker.template.BunkBrandTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BunkBrandDaoImpl implements BunkBrandDao {

    @Autowired
    private BunkBrandTemplate bunkBrandTemplate;

    @Override
    public BunkBrand save(BunkBrand bunkBrandPreSave) {
        return bunkBrandTemplate.save(bunkBrandPreSave);
    }

    @Override
    public BunkBrand getByName(String name) {
        return bunkBrandTemplate.getByName(name);
    }

    @Override
    public BunkBrand getById(String id) {
        return bunkBrandTemplate.getById(id);
    }
}
