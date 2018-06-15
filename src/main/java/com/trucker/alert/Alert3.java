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

@Rule(name = "Third Alert", description = "tire pressure of any tire < 32psi || > 36psi , Priority: LOW", priority = 3)
public class Alert3 {

    @Condition
    public boolean fuelVolume(@Fact("readings")Readings readings){
        int frontLeftTirePressure = readings.getTires().getFrontLeft();
        int frontRightTirePressure = readings.getTires().getFrontRight();
        int rearLeftTirePressure = readings.getTires().getRearLeft();
        int rearRightTirePressure = readings.getTires().getRearRight();
        return (frontLeftTirePressure < 32 || frontLeftTirePressure > 36) || (frontRightTirePressure < 32 || frontRightTirePressure > 36) || (rearLeftTirePressure < 32 || rearRightTirePressure > 36) || (rearRightTirePressure < 32 || rearRightTirePressure > 36 );
    }

    @Action
    public void createAlert(@Fact("repository")AlertRespository repository, @Fact("vehicle")Vehicle vehicle){
        repository.save(new Alert(vehicle,"Tire pressure of any one of the tire is less than 32 psi or greater than 36psi",AlertType.LOW));
    }
}
