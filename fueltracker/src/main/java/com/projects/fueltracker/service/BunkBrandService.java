package com.projects.fueltracker.service;

import com.projects.fueltracker.dao.BunkBrandDao;
import com.projects.fueltracker.exception.BunkBrandAlreadyExistsException;
import com.projects.fueltracker.exception.BunkBrandNotFoundException;
import com.projects.fueltracker.model.collections.BunkBrand;
import com.projects.fueltracker.model.dto.income.BunkBrandDtoIncome;
import com.projects.fueltracker.model.dto.outgo.BunkBrandDtoOutgo;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Log4j2
@Service
public class BunkBrandService {

    @Autowired
    private BunkBrandDao bunkBrandDao;

    @Autowired
    private ModelMapper modelMapper;


    // creating and saving the BunkBrand
    public BunkBrand createBunkBrand(BunkBrand bunkBrand) {
        log.info("Creation for name : '{}', In Progress", bunkBrand.getName());

        BunkBrand alreadyExistingBunkBrand = checkBunkBrandNameAlreadyExists(bunkBrand.getName());
        if(alreadyExistingBunkBrand != null) {
            throw new BunkBrandAlreadyExistsException("Bunk Brand '"+bunkBrand.getName()+"' already exists with id : " + alreadyExistingBunkBrand.get_id());
        }
        BunkBrand bunkBrandPostSave =  bunkBrandDao.save(bunkBrand);

        log.info("Creation for name : '{}', completed", bunkBrand.getName());
        return bunkBrandPostSave;
    }

    public BunkBrand getBunkBrandById(String id) {
        log.info("Fetch of BunkBrand with id : {}, In Progress", id);


        BunkBrand bunkBrand = bunkBrandDao.getById(id);
        if(bunkBrand == null) {
            throw new BunkBrandNotFoundException("Bunk Brand with id '" + id +"', NOT FOUND");
        }

        log.info("Fetch of BunkBrand with id : {}, Completed", id);
        return bunkBrand;
    }

    public BunkBrand updateBunkBrandById(BunkBrand preBunkBrand) {
        log.info("Update for id '{}', In Progress", preBunkBrand.get_id());

        BunkBrand preSavedBunkBrand = checkBunkBrandWithIdExists(preBunkBrand.get_id());
        BunkBrand bunkBrand = bunkBrandDao.save(preBunkBrand);

        log.info("Update for id '{}', Completed", preBunkBrand.get_id());
        return bunkBrand;

    }

    public BunkBrand changeActiveStatus(String id, Boolean activeStatus) {
        log.info("Updating active status for id : '{}', In Progress",id);


        BunkBrand preSavedBunkBrand = checkBunkBrandWithIdExists(id);
        boolean active = preSavedBunkBrand.isActive();
        if(active == activeStatus) {
            log.info("Updating active status for id : '{}', Completed with No Changes in DB",id);
            return null;
        }
        preSavedBunkBrand.setActive(!active);
        BunkBrand postSavedBunkBrand = bunkBrandDao.save(preSavedBunkBrand);


        log.info("Updating active status for id : '{}', Completed",id);
        return postSavedBunkBrand;
    }

//    ---------------------------------------------------------------------------------------------------------
    //Helper functions :

    //to check whether it is present in DB
    private BunkBrand checkBunkBrandNameAlreadyExists(String name) {
        log.info("Checking duplicate entry for name : '{}' In Progress", name);


        BunkBrand bunkBrand = bunkBrandDao.getByName(name);
        String result = bunkBrand == null? "NOT FOUND" : "FOUND";


        log.info("Checking duplicate entry for name : '{}' {}", name, result);
        return bunkBrand;
    }

    private BunkBrand checkBunkBrandWithIdExists(String id) {
        BunkBrand bunkBrand = bunkBrandDao.getById(id);
        if(bunkBrand == null) {
            throw new BunkBrandNotFoundException("Bunk Brand with id '" + id +"', NOT FOUND");
        }
        return bunkBrand;
    }


}

