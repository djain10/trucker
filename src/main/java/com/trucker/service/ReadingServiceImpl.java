package com.trucker.service;

import com.trucker.entity.Readings;
import com.trucker.entity.Vehicle;
import com.trucker.exception.ResourceNotFoundException;
import com.trucker.repository.ReadingRepository;
import com.trucker.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    private ReadingRepository repository;
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    @Transactional
    public void storeReadings(Readings readings) {
        Optional<Vehicle> existing = vehicleRepository.findById(readings.getVin().getVin());
        if (!existing.isPresent()) {
           throw new ResourceNotFoundException("Vehicle with id " + readings.getVin() + " doesn't exist.");
        }
        System.out.println(readings.getVin());
        readings.setVin(existing.get());
         repository.save(readings);
    }
}
