package com.projects.fueltracker.controller;

import com.projects.fueltracker.converter.TripEntryConverter;
import com.projects.fueltracker.model.dto.income.TripEntryDtoIncome;
import com.projects.fueltracker.model.responseWrapper.ApiResponse;
import com.projects.fueltracker.model.responseWrapper.ResponseUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/trip-entry")
@Log4j2
public class TripEntryController {

    @Autowired
    private TripEntryConverter tripEntryConverter;

    // Create ------------------------------------------------------------------------------------------------------------
    @PostMapping
    public ResponseEntity<ApiResponse<com.projects.fueltracker.model.dto.outgo.TripEntryDtoOutgo>> addTripEntry(
            @RequestBody TripEntryDtoIncome tripEntryDtoIncome
    ) {
        log.info("[POST] ==> Creating new trip entry");

        com.projects.fueltracker.model.dto.outgo.TripEntryDtoOutgo tripEntryDtoOutgo = tripEntryConverter.addTripEntry(tripEntryDtoIncome);
        ApiResponse<com.projects.fueltracker.model.dto.outgo.TripEntryDtoOutgo> apiResponse = ResponseUtil.success(201, "Successfully created", tripEntryDtoOutgo, null);

        log.info("[POST] ==> Created trip entry successfully with id: '{}'", tripEntryDtoOutgo.get_id());
        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getStatus()));
    }

    // Read -------------------------------------------------------------------------------------------------------------
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<com.projects.fueltracker.model.dto.outgo.TripEntryDtoOutgo>> getTripEntryById(@PathVariable String id) {
        log.info("[GET] ==> Fetching trip entry by id");

        com.projects.fueltracker.model.dto.outgo.TripEntryDtoOutgo tripEntryDtoOutgo = tripEntryConverter.getTripEntryById(id);
        ApiResponse<com.projects.fueltracker.model.dto.outgo.TripEntryDtoOutgo> apiResponse = ResponseUtil.success(200, "Fetched successfully", tripEntryDtoOutgo, null);

        log.info("[GET] ==> Fetched trip entry successfully with id: '{}'", tripEntryDtoOutgo.get_id());
        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getStatus()));
    }

    // Update -----------------------------------------------------------------------------------------------------------
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<com.projects.fueltracker.model.dto.outgo.TripEntryDtoOutgo>> updateTripEntryById(
            @PathVariable String id,
            @RequestBody TripEntryDtoIncome tripEntryDtoIncome
    ) {
        log.info("[PUT] ==> Updating trip entry by id");

        com.projects.fueltracker.model.dto.outgo.TripEntryDtoOutgo tripEntryDtoOutgo = tripEntryConverter.updateTripEntryById(id, tripEntryDtoIncome);
        ApiResponse<com.projects.fueltracker.model.dto.outgo.TripEntryDtoOutgo> apiResponse = ResponseUtil.success(200, "Updated successfully", tripEntryDtoOutgo, null);

        log.info("[PUT] ==> Updated trip entry successfully with id: '{}'", tripEntryDtoOutgo.get_id());
        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getStatus()));
    }

}
