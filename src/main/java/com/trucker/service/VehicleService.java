package com.trucker.service;

import com.trucker.entity.Alert;
import com.trucker.entity.Vehicle;

import java.util.List;
import java.util.Map;

public interface VehicleService {

     List<Vehicle> create(List <Vehicle> vehicles);
     List<Vehicle> findAll();
     List<Alert> findAlertByVechicleId(String vin);
     List<Map<String,String>> findLocationByVehicleId(String vin);
     List<Alert> findHighAlertOfAllVehicle();

}
