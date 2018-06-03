package com.trukcer.alert;

import com.trukcer.entity.Alert;
import com.trukcer.entity.AlertType;
import com.trukcer.entity.Readings;
import com.trukcer.entity.Vehicle;
import com.trukcer.repository.AlertRespository;
import org.jeasy.rules.annotation.*;

@Rule(name = "First Alert", description = "Rule: engineRpm > readlineRpm, Priority: HIGH", priority = 1)
public class Alert1 {

    @Condition
    public boolean lineRpm(@Fact("readings")Readings readings, @Fact("vehicle")Vehicle vehicle){
        return (readings.getEngineRpm() > vehicle.getRedlineRpm());
    }

    @Action
    public void createAlert(@Fact("repository")AlertRespository repository, @Fact("vehicle")Vehicle vehicle){
        repository.save(new Alert(vehicle,"Engine rpm is more than read line rpm", AlertType.HIGH));
    }
}
