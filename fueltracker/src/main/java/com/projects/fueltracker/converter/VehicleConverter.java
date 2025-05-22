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
        return modelMapper.map(preSaveVehicle, VehicleDtoOutgo.class);
    }

    public VehicleDtoOutgo getVehicleById(String id) {
        Vehicle vehicle = vehicleService.getVehicleById(id);

        //Entity to Dto
        return modelMapper.map(vehicle, VehicleDtoOutgo.class);
    }


    public VehicleDtoOutgo updateVehilceById(String id, VehicleDtoIncome vehicleDtoIncome) {
        //Dto to Entity
        Vehicle preSaveVehicle = modelMapper.map(vehicleDtoIncome, Vehicle.class);
        preSaveVehicle.set_id(id);

        Vehicle postSaveVehicle = vehicleService.updateVehilceById(id, preSaveVehicle);

        //Entity to Dto
        return modelMapper.map(postSaveVehicle, VehicleDtoOutgo.class);


    }
}
