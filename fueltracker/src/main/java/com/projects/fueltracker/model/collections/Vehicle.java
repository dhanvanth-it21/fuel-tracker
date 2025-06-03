package com.projects.fueltracker.model.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Vehicle")
public class Vehicle {

    @Id
    private String _id;
    private String name;
    private String numberPlate;
    private String brandName;
    private String modelName;
    private String[] fuelIds;
    private float fuelTankCapacity;
    private float initialOdometerReading;
    private float odometerReading;
    private boolean hasTripMeter;


    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date updatedDate;


    public Vehicle(String name, String brandName, String numberPlate, String modelName, String[] fuelIds, float fuelTankCapacity, float initialOdometerReading, float odometerReading, boolean hasTripMeter) {
        this.name = name;
        this.brandName = brandName;
        this.numberPlate = numberPlate;
        this.modelName = modelName;
        this.fuelIds = fuelIds;
        this.fuelTankCapacity = fuelTankCapacity;
        this.initialOdometerReading = initialOdometerReading;
        this.odometerReading = odometerReading;
        this.hasTripMeter = hasTripMeter;
    }
}
