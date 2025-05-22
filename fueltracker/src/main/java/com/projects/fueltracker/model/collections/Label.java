package com.projects.fueltracker.model.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "label")
public class Label {

    @Id
    private String _id;

    private String name;
    private Set<String> tripEntryId;

    @CreatedDate
    private Date createdDate = new Date();

    @LastModifiedDate
    private Date updatedDate = new Date();

    public Label(String name, Set<String> tripEntryId) {
        this.name = name;
        this.tripEntryId = tripEntryId;
    }
}
