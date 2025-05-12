package com.projects.fueltracker.controller;

import com.projects.fueltracker.model.dto.income.BunkBrandDtoIncome;
import com.projects.fueltracker.model.dto.outgo.BunkBrandDtoOutgo;
import com.projects.fueltracker.model.responseWrapper.ApiResponse;
import com.projects.fueltracker.model.responseWrapper.ResponseUtil;
import com.projects.fueltracker.service.BunkBrandService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/bunk-brand")
@Log4j2
public class BunkBrandController {

    @Autowired
    private BunkBrandService bunkBrandService;



    //Create------------------------------------------------------------------------------------------------------------

    @PostMapping
    public ResponseEntity<ApiResponse<BunkBrandDtoOutgo>> createBunkBrand(
            @Valid
            @RequestBody
            BunkBrandDtoIncome bunkBrandDtoIncome
    ) {
        BunkBrandDtoOutgo bunkBrandDtoOutgo = bunkBrandService.createBunkBrand(bunkBrandDtoIncome);
        ApiResponse<BunkBrandDtoOutgo> apiResponse = ResponseUtil.success(201, "Created successfully", bunkBrandDtoOutgo, null);
        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getStatus()));

    }

    //Update------------------------------------------------------------------------------------------------------------

    @PutMapping
    public void updateBunkBrand() {

    } //nedd the updated data with respective its _id

    //Read--------------------------------------------------------------------------------------------------------------

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BunkBrandDtoOutgo>> getBunkBrand(
            @PathVariable String id
    ) {
        System.out.println(id);
        BunkBrandDtoOutgo bunkBrandDtoOutgo = null;
        ApiResponse<BunkBrandDtoOutgo> apiResponse = null;
        bunkBrandDtoOutgo = bunkBrandService.getBunkBrandById(id);
        apiResponse = ResponseUtil.success(200, "Fetched successfully", bunkBrandDtoOutgo, null);
        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getStatus()));

    } // get by _id, get all

    //Delete------------------------------------------------------------------------------------------------------------

    @DeleteMapping
    public void deleteBunkBrand() {} //delete a record using the give _id; soft delete



}
