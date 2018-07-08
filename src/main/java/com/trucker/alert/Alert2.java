package com.trucker.alert;

import com.trucker.entity.Alert;
import com.trucker.entity.AlertType;
import com.trucker.entity.Readings;
import com.trucker.entity.Vehicle;
import com.trucker.repository.AlertRespository;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

@Rule(name = "Second Alert", description = "fuelVolume < 10% of maxFuelVolume, Priority: MEDIUM", priority = 2)
public class Alert2 {

    @Condition
    public boolean fuelVolume(@Fact("readings")Readings readings, @Fact("vehicle")Vehicle vehicle){
        return (readings.getFuelVolume() < (0.1 * vehicle.getMaxFuelVolume()));
    }

    @Action
    public void createAlert(@Fact("repository")AlertRespository repository, @Fact("vehicle")Vehicle vehicle){
        repository.save(new Alert(vehicle,"Current fuel volume is less than ten percent of the maximum capacity of fuel volume.",AlertType.MEDIUM));
    }
}