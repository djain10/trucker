package com.trukcer.service;

import com.trukcer.entity.Vehicle;

import java.util.List;

public class VehicleServiceImpl implements VehicleService {

    public Vehicle vehicleDetais() {
        Vehicle vehicle = new Vehicle();
        return  vehicle;
    }

    @Override
    public void vehicleDetails(List<Vehicle> vehicles) {

    }

    @Override
    public Vehicle readings() {
        return null;
    }
}
