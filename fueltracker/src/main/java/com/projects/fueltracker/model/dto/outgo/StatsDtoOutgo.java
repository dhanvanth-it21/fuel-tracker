package com.projects.fueltracker.model.dto.outgo;

import com.projects.fueltracker.model.collections.FuelStats;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatsDtoOutgo {
    private String _id;
    private String VehicleId;
    private Map<String, FuelStats> fuelUsageByType;
}

