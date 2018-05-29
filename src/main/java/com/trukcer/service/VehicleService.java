package com.trukcer.service;

import com.trukcer.entity.Vehicle;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public interface VehicleService {

    void create(List <Vehicle> vehicles);
    public  List<Vehicle> findAll();
}
