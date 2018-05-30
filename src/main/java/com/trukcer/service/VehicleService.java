package com.trukcer.service;

import com.trukcer.entity.Readings;
import com.trukcer.entity.Vehicle;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public interface VehicleService {

    List<Vehicle> create(List <Vehicle> vehicles);
    void vehicleReadingDetails(Readings reading);
    public  List<Vehicle> findAll();
}
