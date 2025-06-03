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
@Document(collection = "stats")
public class Stats {

    @Id
    private String _id;

    private String vehicleId;
    private Map<String, FuelStats> fuelUsageByType;
    private int reserveHits;


    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date updatedDate;

    public Stats(String vehicleId, Map<String, FuelStats> fuelUsageByType, int reserveHits) {
        this.vehicleId = vehicleId;
        this.fuelUsageByType = fuelUsageByType;
        this.reserveHits = reserveHits;
    }
}
