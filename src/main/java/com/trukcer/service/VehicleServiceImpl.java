package com.trukcer.service;

import com.trukcer.entity.Vehicle;
import com.trukcer.repository.VehicleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository repository;

    @Transactional
    public Vehicle create(Vehicle vehicle) {
        Optional<Vehicle> existing = repository.findById(vehicle.getVin());
       // if(existing.isPresent()){
            return repository.save(vehicle);
        //}

        //return repository.save(vehicle);
    }
}
