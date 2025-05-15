package com.projects.fueltracker.controller;

import com.projects.fueltracker.converter.BunkBrandConverter;
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
    private BunkBrandConverter bunkBrandConverter;



    //Create------------------------------------------------------------------------------------------------------------

    @PostMapping
    public ResponseEntity<ApiResponse<BunkBrandDtoOutgo>> createBunkBrand(
            @Valid
            @RequestBody
            BunkBrandDtoIncome bunkBrandDtoIncome
    ) {
        log.info("==> [POST] Start - Creating Bunk Brand: '{}'", bunkBrandDtoIncome.getName());

        BunkBrandDtoOutgo bunkBrandDtoOutgo = bunkBrandConverter.createBunkBrand(bunkBrandDtoIncome);
        ApiResponse<BunkBrandDtoOutgo> apiResponse = ResponseUtil.success(201, "Created successfully", bunkBrandDtoOutgo, null);

        log.info("==> [POST] End - Created Successfully: id='{}', name='{}'",apiResponse.getData().get_id(), apiResponse.getData().getName());
        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getStatus()));
    }

    //Update------------------------------------------------------------------------------------------------------------

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<BunkBrandDtoOutgo>> updateBunkBrand(
            @PathVariable String id,
            @Valid
            @RequestBody BunkBrandDtoIncome bunkBrandDtoIncome
    ) {
        log.info("==> [PUT] Start - Update Bunk Brand for the given id");

        BunkBrandDtoOutgo bunkBrandDtoOutgo = bunkBrandConverter.updateBunkBrand(id, bunkBrandDtoIncome);
        ApiResponse<BunkBrandDtoOutgo> apiResponse = ResponseUtil.success(200, "Update Successfully", bunkBrandDtoOutgo, null);

        log.info("==> [PUT] End - Updated successfully, {}", apiResponse.getData().toString());
        return new ResponseEntity<ApiResponse<BunkBrandDtoOutgo>>(apiResponse, HttpStatusCode.valueOf(apiResponse.getStatus()));
    }

    @PutMapping("/{id}/{activeStatus}")
    public ResponseEntity<ApiResponse<BunkBrandDtoOutgo>> changeActiveStatus(
            @PathVariable String id,
            @PathVariable Boolean activeStatus
    ) {
        log.info("==> [PUT] Start - Change active status for Bunk Brand with the given id");

        BunkBrandDtoOutgo bunkBrandDtoOutgo = bunkBrandConverter.changeActiveStatus(id, activeStatus);
        String message = bunkBrandDtoOutgo == null ? "No Changes Occurred" : "Changed Successfully";
        ApiResponse<BunkBrandDtoOutgo> apiResponse = ResponseUtil.success(200, message, bunkBrandDtoOutgo, null);

        log.info("==> [PUT] Start - Successfully changed");
        return new ResponseEntity<ApiResponse<BunkBrandDtoOutgo>>(apiResponse, HttpStatusCode.valueOf(apiResponse.getStatus()));

    }

    //Read--------------------------------------------------------------------------------------------------------------

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BunkBrandDtoOutgo>> getBunkBrand(
            @PathVariable String id
    ) {
        log.info("==> [GET] Start, BunkBrand for the given id");

        BunkBrandDtoOutgo bunkBrandDtoOutgo = null;
        ApiResponse<BunkBrandDtoOutgo> apiResponse = null;
        bunkBrandDtoOutgo = bunkBrandConverter.getBunkBrandById(id);
        apiResponse = ResponseUtil.success(200, "Fetched successfully", bunkBrandDtoOutgo, null);

        log.info("==> [GET] End, BunkBrand Fetched Successfully, {}", bunkBrandDtoOutgo.toString());
        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getStatus()));

    } // get by _id, get all

    //Delete------------------------------------------------------------------------------------------------------------

    //no need to delete a record, only soft delete, and it is handled by PUT request, to change the active status



}
