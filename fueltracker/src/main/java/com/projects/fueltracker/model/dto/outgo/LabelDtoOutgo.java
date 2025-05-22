package com.projects.fueltracker.model.dto.outgo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LabelDtoOutgo {
    private String _id;

    private String name;
    private Set<String> tripEntryId;
}
