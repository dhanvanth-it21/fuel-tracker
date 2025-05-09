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
@Document(collection = "fuel")
public class Fuel {

    @Id
    private String _id;

    private String name;

    @CreatedDate
    private Date createdDate = new Date();

    @LastModifiedDate
    private Date updatedDate = new Date();


    public Fuel(String name) {
        this.name = name;
    }
}
