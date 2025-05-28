package com.projects.fueltracker.dao.dao_impl;

import com.projects.fueltracker.dao.StatsDao;
import com.projects.fueltracker.model.collections.Stats;
import com.projects.fueltracker.template.StatsTemplate;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class StatsDaoImpl implements StatsDao {

    @Autowired
    private StatsTemplate statsTemplate;

    @Override
    public void save(Stats stats) {
        log.info("[STATS DAO] Saving stats for vehicleId: {}", stats.getVehicleId());
        statsTemplate.save(stats);
    }

    @Override
    public Stats getByVehicleId(String vehicleId) {
        log.info("[STATS DAO] Fetching stats for vehicleId: {}", vehicleId);
        Stats stats = statsTemplate.findByVehicleId(vehicleId);
        if (stats == null) {
            log.warn("[STATS DAO] No stats found for vehicleId: {}", vehicleId);
        }
        return stats;
    }

    @Override
    public void updateByVehicleId(String vehicleId, Stats stats) {
        log.info("[STATS DAO] Updating stats for vehicleId: {}", vehicleId);
        statsTemplate.updateByVehicleId(vehicleId, stats);
    }
}
