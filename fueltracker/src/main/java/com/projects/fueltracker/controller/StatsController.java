package com.projects.fueltracker.controller;

import com.projects.fueltracker.converter.StatsConverter;
import com.projects.fueltracker.model.dto.outgo.StatsDtoOutgo;
import com.projects.fueltracker.model.responseWrapper.ApiResponse;
import com.projects.fueltracker.model.responseWrapper.ResponseUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/stats")
@Log4j2
public class StatsController {

    @Autowired
    private StatsConverter statsConverter;

    //Read--------------------------------------------------------------------------------------------------------------
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<StatsDtoOutgo>> getStats(
            @PathVariable
            String id
    ) {
        ApiResponse<StatsDtoOutgo> apiResponse = ResponseUtil.success(200, "demo", null, null);
        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getStatus()));
    }
}
