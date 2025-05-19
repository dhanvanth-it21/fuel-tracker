package com.projects.fueltracker.dao.dao_impl;

import com.projects.fueltracker.dao.BunkDao;
import com.projects.fueltracker.exception.ResourceNotFoundException;
import com.projects.fueltracker.model.collections.Bunk;
import com.projects.fueltracker.template.BunkTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BunkDaoImpl implements BunkDao {

    @Autowired
    private BunkTemplate bunkTemplate;

    @Override
    public Bunk save(Bunk bunk) {
        return bunkTemplate.save(bunk);
    }

    @Override
    public Bunk getById(String id) {
        Bunk bunk = bunkTemplate.getById(id);
        if(bunk == null) {
            throw new ResourceNotFoundException("Bunk with id '"+id+"' not found in records");
        }
        return bunk;
    }

    @Override
    public Bunk updateById(Bunk preSaveBunk) {
        String id = preSaveBunk.get_id();
        Bunk bunk = bunkTemplate.getById(id);
        if(bunk == null) {
            throw new ResourceNotFoundException("Bunk with id '"+id+"' not found in records");
        }
        return bunkTemplate.updateById(preSaveBunk);
    }
}
