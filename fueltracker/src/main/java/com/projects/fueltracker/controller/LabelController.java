package com.projects.fueltracker.controller;

import com.projects.fueltracker.converter.LabelConverter;
import com.projects.fueltracker.model.dto.income.LabelDtoIncome;
import com.projects.fueltracker.model.dto.outgo.LabelDtoOutgo;
import com.projects.fueltracker.model.responseWrapper.ApiResponse;
import com.projects.fueltracker.model.responseWrapper.ResponseUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/label")
@Log4j2
public class LabelController {

    @Autowired
    private LabelConverter labelConverter;

    // Create ---------------------------------------------------------------------------------------------------------
    @PostMapping
    public ResponseEntity<ApiResponse<LabelDtoOutgo>> addLabel(
            @RequestBody LabelDtoIncome labelDtoIncome
    ) {
        log.info("[POST] ==> Creating new label");

        LabelDtoOutgo labelDtoOutgo = labelConverter.addLabel(labelDtoIncome);
        ApiResponse<LabelDtoOutgo> apiResponse = ResponseUtil.success(201, "Successfully created", labelDtoOutgo, null);

        log.info("[POST] ==> Created label successfully with id: '{}'", labelDtoOutgo.get_id());
        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getStatus()));
    }

    // Read -----------------------------------------------------------------------------------------------------------
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<LabelDtoOutgo>> getLabelById(
            @PathVariable String id
    ) {
        log.info("[GET] ==> Fetching label by id");

        LabelDtoOutgo labelDtoOutgo = labelConverter.getLabelById(id);
        ApiResponse<LabelDtoOutgo> apiResponse = ResponseUtil.success(200, "Fetched successfully", labelDtoOutgo, null);

        log.info("[GET] ==> Fetched label successfully with id: '{}'", labelDtoOutgo.get_id());
        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getStatus()));
    }

    // Update ---------------------------------------------------------------------------------------------------------
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<LabelDtoOutgo>> updateLabelById(
            @PathVariable String id,
            @RequestBody LabelDtoIncome labelDtoIncome
    ) {
        log.info("[PUT] ==> Updating label by id");

        LabelDtoOutgo labelDtoOutgo = labelConverter.updateLabelById(id, labelDtoIncome);
        ApiResponse<LabelDtoOutgo> apiResponse = ResponseUtil.success(200, "Updated successfully", labelDtoOutgo, null);

        log.info("[PUT] ==> Updated label successfully with id: '{}'", labelDtoOutgo.get_id());
        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getStatus()));
    }
}
