package com.projects.fueltracker.model.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "bunk")
public class Bunk {

    @Id
    private String _id;

    private String name;
    private String brandId;
    private String state;
    private String district;
    private String place;
    private String description;


    @CreatedDate
    private Date createdDate = new Date();

    @LastModifiedDate
    private Date updatedDate = new Date();


    public Bunk(String name, String brandId, String state, String district, String place, String description) {
        this.name = name;
        this.brandId = brandId;
        this.state = state;
        this.district = district;
        this.place = place;
        this.description = description;
    }
}
