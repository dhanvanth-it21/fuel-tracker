package com.projects.fueltracker.controller;

import com.projects.fueltracker.converter.FuelConverter;
import com.projects.fueltracker.model.dto.income.FuelDtoIncome;
import com.projects.fueltracker.model.dto.outgo.FuelDtoOutgo;
import com.projects.fueltracker.model.responseWrapper.ApiResponse;
import com.projects.fueltracker.model.responseWrapper.ResponseUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/fuel")
@Log4j2
public class FuelController {

    @Autowired
    private FuelConverter fuelConverter;

    //Create------------------------------------------------------------------------------------------
    @PostMapping
    public ResponseEntity<ApiResponse<FuelDtoOutgo>> addFuel(
            @RequestBody
            FuelDtoIncome fuelDtoIncome
    ) {
        log.info("[POST] ==> Adding new fuel");

        FuelDtoOutgo fuelDtoOutgo = fuelConverter.addFuel(fuelDtoIncome);
        ApiResponse<FuelDtoOutgo> apiResponse = ResponseUtil.success(201,"Successfully created", fuelDtoOutgo, null);

        log.info("[POST] ==> Added a new Fuel successfully, with the id : '{}'", fuelDtoOutgo.get_id());
        return new ResponseEntity<ApiResponse<FuelDtoOutgo>>(apiResponse, HttpStatusCode.valueOf(apiResponse.getStatus()));
    }
    //Read--------------------------------------------------------------------------------------------
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<FuelDtoOutgo>> getFuelById(
            @PathVariable
            String id
    ) {
        log.info("[GET] ==> Fetching Fuel by ID");

        FuelDtoOutgo fuelDtoOutgo = fuelConverter.getFuelById(id);
        ApiResponse<FuelDtoOutgo> apiResponse = ResponseUtil.success(200, "Fetched successfully", fuelDtoOutgo, null);

        log.info("[GET] ==> Fetched Fuel successfully by Id : {}", fuelDtoOutgo.get_id());
        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getStatus()));

    }
    //Update------------------------------------------------------------------------------------------
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<FuelDtoOutgo>> updateFuelById(
            @PathVariable
            String id,
            @RequestBody
            FuelDtoIncome fuelDtoIncome
    ) {
        log.info("[PUT] ==> Updating Fuel by ID");

        FuelDtoOutgo fuelDtoOutgo = fuelConverter.updateFuelById(id, fuelDtoIncome);
        ApiResponse<FuelDtoOutgo> apiResponse = ResponseUtil.success(200, "Fetched successfully", fuelDtoOutgo, null);

        log.info("[PUT] ==> Updated Fuel successfully by Id : {}", fuelDtoOutgo.get_id());
        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getStatus()));

    }
}
