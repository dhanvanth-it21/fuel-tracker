package com.projects.fueltracker.model.dto.outgo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripEntryDtoOutgo {
    private String _id;
    private String VehicleId;
    private String tripName;
    private float baseOdometerReading;
    private float tripStart;
    private float[] tripMid;
    private float tripEnd;
    private Date tripDateStart;
    private Date tripDateEnd;
    private Set<String> labelsId;
}
