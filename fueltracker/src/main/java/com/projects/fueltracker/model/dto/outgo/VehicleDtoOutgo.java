package com.projects.fueltracker.model.dto.outgo;

import com.projects.fueltracker.model.collections.FuelStats;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDtoOutgo {

    private String _id;
    private String name;
    private String numberPlate;
    private String brandName;
    private String modelName;
    private String[] fuelIds;
    private float fuelTankCapacity;
    private float initialOdometerReading;
    private float odometerReading;
    private boolean hasTripMeter;
}
