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

@Rule(name = "Fourth Alert", description = "engineCoolantLow = true || checkEngineLightOn = true, Priority: LOW", priority = 3)
public class Alert4 {

    @Condition
    public boolean lineRpm(@Fact("readings")Readings readings){
        return  readings.isEngineCoolantLow() || readings.isCheckEngineLightOn() ;
    }

    @Action
    public void createAlert(@Fact("repository")AlertRespository repository, @Fact("vehicle")Vehicle vehicle){
        repository.save(new Alert(vehicle,"Either coolant of engine is low or engine light is on.", AlertType.LOW));
    }
}