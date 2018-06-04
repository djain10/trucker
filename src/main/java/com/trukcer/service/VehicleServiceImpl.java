package com.trukcer.service;

import com.trukcer.entity.Alert;
import com.trukcer.entity.Readings;
import com.trukcer.entity.Vehicle;
import com.trukcer.exception.ResourceNotFoundException;
import com.trukcer.repository.AlertRespository;
import com.trukcer.repository.ReadingRepository;
import com.trukcer.repository.VehicleRepository;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository repository;
    @Autowired
    private AlertRespository alertRespository;

    @Autowired
    private ReadingRepository readingRepository;

    @Override
    @Transactional
    public List<Vehicle> create(List <Vehicle> vehicles) {
                repository.saveAll(vehicles);

            return repository.findAll();
    }

    public List<Vehicle> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public List<Alert> findAlertByVechicleId(String vin) {
        Optional<Vehicle> existing = repository.findById(vin);
        if(!existing.isPresent()){
            throw new ResourceNotFoundException("Vehicle id:" + vin + "doesnt exist.");
        }

        return alertRespository.findByVehicle(existing.get());
    }

    @Override
    @Transactional
    public List<Map<String, String>> findLocationByVehicleId(String vin) {
        Optional<Vehicle> existing = repository.findById(vin);
        if(!existing.isPresent()){
            throw new ResourceNotFoundException("Vehicle id:" + vin + "doesnt exist.");
        }

        LocalDateTime currentTime = LocalDateTime.now();
        return  readingRepository.findLocationByVehicle( currentTime.minusMinutes(30), currentTime, existing.get() );
    }

    @Override
    @Transactional
    public List<Alert> findHighAlertOfAllVehicle() {
        LocalDateTime currentTime = LocalDateTime.now();
        return alertRespository.findByVehicleAndTypeEqualsHigh( currentTime.minusHours(2), currentTime );
    }
}
