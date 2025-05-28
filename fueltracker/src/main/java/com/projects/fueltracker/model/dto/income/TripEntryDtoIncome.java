package com.projects.fueltracker.model.dto.income;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripEntryDtoIncome {
    private String VehicleId;
    private String tripName;
    private float baseOdometerReading;
    private float tripStart;
    private float[] tripMid;
    private float tripEnd;
    private Date tripDateStart;
    private Date tripDateEnd;
    private Set<String> labelIds;
}
