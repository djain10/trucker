package com.trukcer.service;

import com.trukcer.entity.Readings;
import com.trukcer.entity.Vehicle;
import com.trukcer.repository.VehicleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository repository;

    @Transactional
    public List<Vehicle> create(List <Vehicle> vehicles) {
                repository.saveAll(vehicles);
            return repository.findAll();
    }

    public void vehicleReadingDetails(Readings reading) {

    }

    public List<Vehicle> findAll() {
        return repository.findAll();
    }
}
