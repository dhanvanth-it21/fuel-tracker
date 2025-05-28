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
@Document(collection = "trip_entry")
public class TripEntry {

    @Id
    private String _id;

    private String VehicleId;
    private String tripName;
    private float baseOdometerReading;
    private float tripStart;
    private float[] tripMid;
    private float tripEnd;
    private Date tripDateStart;
    private Date tripDateEnd;
    private Set<String> labelIds;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date updatedDate;


    public TripEntry(String vehicleId, String tripName, float baseOdometerReading, float tripStart, float[] tripMid, float tripEnd, Date tripDateStart, Date tripDateEnd, Set<String> labelsId) {
        VehicleId = vehicleId;
        this.tripName = tripName;
        this.baseOdometerReading = baseOdometerReading;
        this.tripStart = tripStart;
        this.tripMid = tripMid;
        this.tripEnd = tripEnd;
        this.tripDateStart = tripDateStart;
        this.tripDateEnd = tripDateEnd;
        this.labelIds = labelsId;
    }
}
