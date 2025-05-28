package com.projects.fueltracker.service;

import com.projects.fueltracker.dao.StatsDao;
import com.projects.fueltracker.exception.ResourceNotFoundException;
import com.projects.fueltracker.model.collections.FuelEntry;
import com.projects.fueltracker.model.collections.FuelStats;
import com.projects.fueltracker.model.collections.Stats;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Log4j2
public class StatsService {

    @Autowired
    public StatsDao statsDao;

    public void updateFuelStatsOnNewEntry(String vehicleId, FuelEntry fuelEntry) {
        Stats stats = statsDao.getByVehicleId(vehicleId);

        if (stats == null) {
            throw new ResourceNotFoundException("Stats not found for vehicleId: " + vehicleId);
        }

        Map<String, FuelStats> usageMap = stats.getFuelUsageByType();
        if (usageMap == null) {
            usageMap = new HashMap<>();
        }

        String fuelId = fuelEntry.getFuelId();
        float fuelLiters = fuelEntry.getFuelLiter();
        float fuelAmount = fuelEntry.getFuelAmount();

        FuelStats fuelStats = usageMap.getOrDefault(fuelId, new FuelStats(0, 0));
        fuelStats.setTotalFuelUsed(fuelStats.getTotalFuelUsed() + fuelLiters);
        fuelStats.setTotalAmountSpent(fuelStats.getTotalAmountSpent() + fuelAmount);

        usageMap.put(fuelId, fuelStats);
        stats.setFuelUsageByType(usageMap);

        statsDao.updateByVehicleId(vehicleId, stats);

        log.info("[STATS SERVICE] Updated stats for vehicleId: {}, fuelId: {}", vehicleId, fuelId);
    }
}
