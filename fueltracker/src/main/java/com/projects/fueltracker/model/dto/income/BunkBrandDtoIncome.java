package com.projects.fueltracker.model.dto.income;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BunkBrandDtoIncome {

    @NotEmpty(message = "Name must not be Empty and NULL")
    private String name;

    @Builder.Default
    private boolean isActive = true;

}
