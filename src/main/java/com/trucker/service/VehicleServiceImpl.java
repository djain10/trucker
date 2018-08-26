package com.trucker.service;

import com.trucker.entity.Alert;
import com.trucker.entity.Vehicle;
import com.trucker.exception.ResourceNotFoundException;
import com.trucker.repository.AlertRespository;
import com.trucker.repository.ReadingRepository;
import com.trucker.repository.VehicleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
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
