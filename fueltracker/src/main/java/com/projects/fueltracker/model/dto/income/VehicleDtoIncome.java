package com.projects.fueltracker.model.dto.income;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private float odometerReading;
    private float totalFuelUsed;
    private float totalAmountSpent;
    private boolean hasTripMeter;
}
