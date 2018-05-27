package com.trukcer.service;

import com.trukcer.entity.Vehicle;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public interface VehicleService {
    void vehicleDetails(List<Vehicle> vehicles);
    Vehicle readings();
}
