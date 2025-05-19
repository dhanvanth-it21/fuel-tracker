package com.projects.fueltracker.dao;

import com.projects.fueltracker.model.collections.Bunk;
import org.springframework.stereotype.Service;

@Service
public interface BunkDao {
    Bunk save(Bunk bunk);

    Bunk getById(String id);

    Bunk updateById(Bunk preSaveBunk);
}
