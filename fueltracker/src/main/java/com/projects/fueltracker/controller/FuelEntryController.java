package com.projects.fueltracker.controller;

import com.projects.fueltracker.converter.FuelEntryConverter;
import com.projects.fueltracker.model.dto.income.FuelEntryDtoIncome;
import com.projects.fueltracker.model.dto.outgo.FuelEntryDtoOutgo;
import com.projects.fueltracker.model.responseWrapper.ApiResponse;
import com.projects.fueltracker.model.responseWrapper.ResponseUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/fuel-entry")
@Log4j2
public class FuelEntryController {

    @Autowired
    private FuelEntryConverter fuelEntryConverter;

    // Create ----------------------------------------------------------------------------------------
    @PostMapping
    public ResponseEntity<ApiResponse<FuelEntryDtoOutgo>> addFuelEntry(
            @RequestBody FuelEntryDtoIncome fuelEntryDtoIncome
    ) {
        log.info("[POST] ==> Adding new FuelEntry");

        FuelEntryDtoOutgo fuelEntryDtoOutgo = fuelEntryConverter.addFuelEntry(fuelEntryDtoIncome);
        ApiResponse<FuelEntryDtoOutgo> apiResponse = ResponseUtil.success(201, "Successfully created", fuelEntryDtoOutgo, null);

        log.info("[POST] ==> Added new FuelEntry successfully, with id : '{}'", fuelEntryDtoOutgo.get_id());
        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getStatus()));
    }

    // Read ------------------------------------------------------------------------------------------
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<FuelEntryDtoOutgo>> getFuelEntryById(
            @PathVariable String id
    ) {
        log.info("[GET] ==> Fetching FuelEntry by ID");

        FuelEntryDtoOutgo fuelEntryDtoOutgo = fuelEntryConverter.getFuelEntryById(id);
        ApiResponse<FuelEntryDtoOutgo> apiResponse = ResponseUtil.success(200, "Fetched successfully", fuelEntryDtoOutgo, null);

        log.info("[GET] ==> Fetched FuelEntry successfully by Id : {}", fuelEntryDtoOutgo.get_id());
        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getStatus()));
    }

    // Update ----------------------------------------------------------------------------------------
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<FuelEntryDtoOutgo>> updateFuelEntryById(
            @PathVariable String id,
            @RequestBody FuelEntryDtoIncome fuelEntryDtoIncome
    ) {
        log.info("[PUT] ==> Updating FuelEntry by ID");

        FuelEntryDtoOutgo fuelEntryDtoOutgo = fuelEntryConverter.updateFuelEntryById(id, fuelEntryDtoIncome);
        ApiResponse<FuelEntryDtoOutgo> apiResponse = ResponseUtil.success(200, "Updated successfully", fuelEntryDtoOutgo, null);

        log.info("[PUT] ==> Updated FuelEntry successfully by Id : {}", fuelEntryDtoOutgo.get_id());
        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getStatus()));
    }
}
