package com.trukcer.service;

import com.trukcer.entity.Readings;
import com.trukcer.entity.Vehicle;
import com.trukcer.exception.ResourceNotFoundException;
import com.trukcer.repository.ReadingRepository;
import com.trukcer.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    ReadingRepository repository;
    @Autowired
    VehicleRepository vehicleRepository;

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
