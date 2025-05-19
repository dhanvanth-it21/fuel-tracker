package com.projects.fueltracker.service;

import com.projects.fueltracker.dao.BunkDao;
import com.projects.fueltracker.model.collections.Bunk;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class BunkService {

    @Autowired
    private BunkDao bunkDao;

    public Bunk addBunk(Bunk preSaveBunk) {
        log.info("Adding New Bunk : In Progress");

        Bunk bunk = bunkDao.save(preSaveBunk);

        log.info("Adding new Bunk : Completed");
        return bunk;
    }

    public Bunk updateBunk(Bunk preSaveBunk) {
        log.info("Updating Bunk : In Progress");

        Bunk bunk = bunkDao.updateById(preSaveBunk);

        log.info("Updating Bunk : Completed");
        return  bunk;
    }

    public Bunk getBunkById(String id) {
        log.info("Fetching Bunk : In Progress");

        Bunk bunk = bunkDao.getById(id);

        log.info("Fetching Bunk : Completed");
        return  bunk;
    }
}
