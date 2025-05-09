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
@Document(collection = "fuel_entry")
public class FuelEntry {

    @Id
    private String _id;

    private String vehicleId;
    private float odometerReading;
    private boolean isReserveUsed;
    private float tripFReading;
    private Date fueledDate;
    private float fuelPricePerLiter;
    private float fuelLiter;
    private float fuelAmount;
    private String bunkId;

    @CreatedDate
    private Date createdDate = new Date();

    @LastModifiedDate
    private Date updatedDate = new Date();


    public FuelEntry(String vehicleId, String bunkId, float fuelAmount, float fuelLiter, float fuelPricePerLiter, Date fueledDate, boolean isReserveUsed, float odometerReading, float tripFReading) {
        this.vehicleId = vehicleId;
        this.bunkId = bunkId;
        this.fuelAmount = fuelAmount;
        this.fuelLiter = fuelLiter;
        this.fuelPricePerLiter = fuelPricePerLiter;
        this.fueledDate = fueledDate;
        this.isReserveUsed = isReserveUsed;
        this.odometerReading = odometerReading;
        this.tripFReading = tripFReading;
    }

}
