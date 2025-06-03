package com.projects.fueltracker.model.dto.outgo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuelEntryDtoOutgo {

    private String _id;
    private String vehicleId;
    private float odometerReading;
    private boolean reserveUsed;
    private float tripFReading;
    private String fuelId;
    private long fueledDateInMilli;
    private float fuelPricePerLiter;
    private float fuelLiter;
    private float fuelAmount;
    private String bunkId;
}
