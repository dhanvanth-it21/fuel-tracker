package com.projects.fueltracker.converter;

import com.projects.fueltracker.model.collections.Label;
import com.projects.fueltracker.model.dto.income.LabelDtoIncome;
import com.projects.fueltracker.model.dto.outgo.LabelDtoOutgo;
import com.projects.fueltracker.service.LabelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabelConverter {

    @Autowired
    private LabelService labelService;

    @Autowired
    private ModelMapper modelMapper;

    public LabelDtoOutgo addLabel(LabelDtoIncome labelDtoIncome) {
        // DTO to Entity
        Label preSaveLabel = modelMapper.map(labelDtoIncome, Label.class);

        // Save via service
        Label postSaveLabel = labelService.addLabel(preSaveLabel);

        // Entity to DTO
        return modelMapper.map(postSaveLabel, LabelDtoOutgo.class);
    }

    public LabelDtoOutgo getLabelById(String id) {
        // Fetch via service
        Label label = labelService.getLabelById(id);

        // Entity to DTO
        return modelMapper.map(label, LabelDtoOutgo.class);
    }

    public LabelDtoOutgo updateLabelById(String id, LabelDtoIncome labelDtoIncome) {
        // DTO to Entity
        Label preSaveLabel = modelMapper.map(labelDtoIncome, Label.class);
        preSaveLabel.set_id(id); // Assuming Mongo-style _id

        // Update via service
        Label updatedLabel = labelService.updateLabelById(preSaveLabel);

        // Entity to DTO
        return modelMapper.map(updatedLabel, LabelDtoOutgo.class);
    }
}
