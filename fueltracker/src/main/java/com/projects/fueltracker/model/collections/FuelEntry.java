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
    private String fuelId;
    private Date fueledDate;
    private float fuelPricePerLiter;
    private float fuelLiter;
    private float fuelAmount;
    private String bunkId;

    @CreatedDate
    private Date createdDate = new Date();

    @LastModifiedDate
    private Date updatedDate = new Date();


    public FuelEntry(String vehicleId, float odometerReading, boolean isReserveUsed, float tripFReading, String fuelId, Date fueledDate, float fuelPricePerLiter, float fuelLiter, float fuelAmount, String bunkId) {
        this.vehicleId = vehicleId;
        this.odometerReading = odometerReading;
        this.isReserveUsed = isReserveUsed;
        this.tripFReading = tripFReading;
        this.fuelId = fuelId;
        this.fueledDate = fueledDate;
        this.fuelPricePerLiter = fuelPricePerLiter;
        this.fuelLiter = fuelLiter;
        this.fuelAmount = fuelAmount;
        this.bunkId = bunkId;
    }
}
