package com.projects.fueltracker.model.dto.income;

import com.projects.fueltracker.model.collections.FuelStats;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDtoIncome {

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
