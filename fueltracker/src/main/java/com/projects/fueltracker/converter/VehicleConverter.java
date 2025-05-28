package com.projects.fueltracker.converter;

import com.projects.fueltracker.model.collections.Vehicle;
import com.projects.fueltracker.model.dto.income.VehicleDtoIncome;
import com.projects.fueltracker.model.dto.outgo.VehicleDtoOutgo;
import com.projects.fueltracker.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleConverter {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private ModelMapper modelMapper;

    public VehicleDtoOutgo addVehicle(VehicleDtoIncome vehicleDtoIncome) {
        //Dto to Entity
        Vehicle preSaveVehicle = modelMapper.map(vehicleDtoIncome, Vehicle.class);

        Vehicle postSaveVehicle = vehicleService.addVehicle(preSaveVehicle);

        //Entity to Dto
        return modelMapper.map(postSaveVehicle, VehicleDtoOutgo.class);
    }

    public VehicleDtoOutgo getVehicleById(String id) {
        Vehicle vehicle = vehicleService.getVehicleById(id);

        //Entity to Dto
        return modelMapper.map(vehicle, VehicleDtoOutgo.class);
    }


    public VehicleDtoOutgo updateVehicleById(String id, VehicleDtoIncome vehicleDtoIncome) {
        //Dto to Entity
        Vehicle preSaveVehicle = vehicleService.getVehicleById(id);
        modelMapper.map(vehicleDtoIncome, preSaveVehicle);

        Vehicle postSaveVehicle = vehicleService.updateVehicleById(id, preSaveVehicle);
        preSaveVehicle.set_id(id);



        //Entity to Dto
        return modelMapper.map(postSaveVehicle, VehicleDtoOutgo.class);


    }
}
