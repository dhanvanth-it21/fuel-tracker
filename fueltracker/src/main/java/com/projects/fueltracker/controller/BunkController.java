package com.projects.fueltracker.controller;

import com.projects.fueltracker.converter.BunkConverter;
import com.projects.fueltracker.model.dto.income.BunkDtoIncome;
import com.projects.fueltracker.model.dto.outgo.BunkDtoOutgo;
import com.projects.fueltracker.model.responseWrapper.ApiResponse;
import com.projects.fueltracker.model.responseWrapper.ResponseUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/bunk")
@Log4j2
public class BunkController {

    @Autowired
    private BunkConverter bunkConverter;

    //api controllers :
    // ==> addBunk()
    // ==> updateBunk()
    // ==> aaaaaaaaa()
    // ==> aaaaaaaaa()

    //Create

    @PostMapping
    public ResponseEntity<ApiResponse<BunkDtoOutgo>> addBunk(
            @RequestBody
            BunkDtoIncome bunkDtoIncome
    ) {
        log.info("[POST] ==> Adding New Bunk");

        BunkDtoOutgo bunkDtoOutgo = bunkConverter.addBunk(bunkDtoIncome);
        ApiResponse<BunkDtoOutgo> apiResponse = ResponseUtil.success(201, "Successfully created", bunkDtoOutgo, null);

        log.info("[POST] ==> Added a new Bunk successfully, with the id : '{}'", bunkDtoOutgo.get_id());
        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getStatus()));
    }

    //Update

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<BunkDtoOutgo>> updateBunk(
            @PathVariable
            String id,
            @RequestBody
            BunkDtoIncome bunkDtoIncome
    ) {
        log.info("[PUT] ==> Updating Bunk for the given Id");

        BunkDtoOutgo bunkDtoOutgo = bunkConverter.updateBunk(id, bunkDtoIncome);
        ApiResponse<BunkDtoOutgo> apiResponse = ResponseUtil.success(200, "Updated successfully", bunkDtoOutgo, null);

        log.info("[PUT] ==> Updated Bunk successfully, with the id : '{}'", bunkDtoOutgo.get_id());
        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getStatus()));
    }

    //Read

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BunkDtoOutgo>> getBunk(
            @PathVariable
            String id
    ) {
        log.info("[GET] ==> Fetching Bunk with the given Id");

        BunkDtoOutgo bunkDtoOutgo = bunkConverter.getBunkById(id);
        ApiResponse<BunkDtoOutgo> apiResponse = ResponseUtil.success(200, "Fetched successfully", bunkDtoOutgo, null);

        log.info("[get] ==> Fetched  Bunk successfully, with the id : '{}'", bunkDtoOutgo.get_id());
        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getStatus()));

    }

    //Delete

    @DeleteMapping
    public void deleteBunk() {}

}
