package com.trukcer.service;

import com.trukcer.entity.Vehicle;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Service
public interface VehicleService {

    Vehicle create(Vehicle vehicle);
}
