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
@Document(collection = "Vehicle")
public class Vehicle {

    @Id
    private String _id;
    private String name;
    private String numberPlate;
    private String brandName;
    private String modelName;
    private String fuelId;
    private float fuelTankCapacity;
    private float odometerReading;
    private float totalFuelUsed;
    private float totalAmountSpent;
    private boolean hasTripMeter;


    @CreatedDate
    private Date createdDate = new Date();

    @LastModifiedDate
    private Date updatedDate = new Date();


    public Vehicle(String name, String numberPlate, String brandName, String modelName, String fuelId, float fuelTankCapacity, float odometerReading, float totalFuelUsed, float totalAmountSpent, boolean hasTripMeter) {
        this.name = name;
        this.numberPlate = numberPlate;
        this.brandName = brandName;
        this.modelName = modelName;
        this.fuelId = fuelId;
        this.fuelTankCapacity = fuelTankCapacity;
        this.odometerReading = odometerReading;
        this.totalFuelUsed = totalFuelUsed;
        this.totalAmountSpent = totalAmountSpent;
        this.hasTripMeter = hasTripMeter;
    }
}
