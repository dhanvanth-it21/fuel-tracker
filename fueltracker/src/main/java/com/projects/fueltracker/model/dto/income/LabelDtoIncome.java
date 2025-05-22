package com.projects.fueltracker.model.dto.income;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LabelDtoIncome {
    private String name;
    private Set<String> tripEntryId;
}
