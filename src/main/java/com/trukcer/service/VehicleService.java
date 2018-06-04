package com.trukcer.service;

import com.trukcer.entity.Alert;
import com.trukcer.entity.Readings;
import com.trukcer.entity.Vehicle;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public interface VehicleService {

     List<Vehicle> create(List <Vehicle> vehicles);
     List<Vehicle> findAll();
     List<Alert> findAlertByVechicleId(String vin);
     List<Map<String,String>> findLocationByVehicleId(String vin);
     List<Alert> findHighAlertOfAllVehicle();

}
