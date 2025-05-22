package com.projects.fueltracker.service;

import com.projects.fueltracker.dao.LabelDao;
import com.projects.fueltracker.model.collections.Label;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class LabelService {

    @Autowired
    private LabelDao labelDao;

    public Label addLabel(Label preSaveLabel) {
        log.info("Creating Label, In Progress");

        Label label = labelDao.addLabel(preSaveLabel);

        log.info("Creating Label, Completed");
        return label;
    }

    public Label getLabelById(String id) {
        log.info("Fetching Label with id: '{}', In Progress", id);

        Label label = labelDao.getById(id);

        log.info("Fetching Label with id: '{}', Completed", id);
        return label;
    }

    public Label updateLabelById(Label preSaveLabel) {
        String id = preSaveLabel.get_id();
        log.info("Updating Label with id: '{}', In Progress", id);

        Label label = labelDao.updateByID(preSaveLabel);

        log.info("Updating Label with id: '{}', Completed", id);
        return label;
    }
}
