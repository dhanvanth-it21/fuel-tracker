package com.projects.fueltracker.model.dto.outgo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BunkBrandDtoOutgo {

    private String _id;
    private String name;
    private boolean active;

}
