package com.projects.fueltracker.model.dto.income;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BunkDtoIncome {
    private String name;
    private String brandId;
    private String state;
    private String district;
    private String place;
    private String description;
}
