package com.projects.fueltracker.controller;

import com.projects.fueltracker.converter.VehicleConverter;
import com.projects.fueltracker.model.dto.income.VehicleDtoIncome;
import com.projects.fueltracker.model.dto.outgo.VehicleDtoOutgo;
import com.projects.fueltracker.model.responseWrapper.ApiResponse;
import com.projects.fueltracker.model.responseWrapper.ResponseUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/vehicle")
@Log4j2
public class VehicleController {

    @Autowired
    private VehicleConverter vehicleConverter;

    //Create------------------------------------------------------------------------------------------------------------
    @PostMapping
    public ResponseEntity<ApiResponse<VehicleDtoOutgo>> addVehicle(
            @RequestBody
            VehicleDtoIncome vehicleDtoIncome
    ) {
        log.info("[POST] ==> Creating new vehicle");

        VehicleDtoOutgo vehicleDtoOutgo = vehicleConverter.addVehicle(vehicleDtoIncome);
        ApiResponse<VehicleDtoOutgo> apiResponse = ResponseUtil.success(201, "Sucessfully created", vehicleDtoOutgo, null);

        log.info("[POST] ==> Created vehicle successfully with the id: '{}'", vehicleDtoOutgo.get_id());
        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getStatus()));

    }
    //Read--------------------------------------------------------------------------------------------------------------
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<VehicleDtoOutgo>> getVehicleById(
            @PathVariable
            String id
    ) {
        log.info("[GET] ==> Fetching vehicle by id");

        VehicleDtoOutgo  vehicleDtoOutgo = vehicleConverter.getVehicleById(id);
        ApiResponse<VehicleDtoOutgo> apiResponse = ResponseUtil.success(200, "Fetched successfully", vehicleDtoOutgo, null);

        log.info("[GET] ==> Fetched vehicle successfully with the id : '{}'", vehicleDtoOutgo.get_id());
        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getStatus()));

    }
    //Update------------------------------------------------------------------------------------------------------------
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<VehicleDtoOutgo>> updateVehilceById(
            @PathVariable
            String id,
            @RequestBody
            VehicleDtoIncome vehicleDtoIncome
    ) {
        log.info("[PUT] ==> Updating vehicle by id");

        VehicleDtoOutgo  vehicleDtoOutgo = vehicleConverter.updateVehilceById(id, vehicleDtoIncome);
        ApiResponse<VehicleDtoOutgo> apiResponse = ResponseUtil.success(200, "Updated successfully", vehicleDtoOutgo, null);

        log.info("[PUT] ==> Updated vehicle successfully by id : '{}", vehicleDtoOutgo.get_id());
        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(apiResponse.getStatus()));
    }
}
