package com.trukcer.service;

import com.trukcer.entity.Readings;
import com.trukcer.entity.Vehicle;
import com.trukcer.exception.ResourceNotFoundException;
import com.trukcer.repository.ReadingRepository;
import com.trukcer.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    ReadingRepository repository;
    @Autowired
    VehicleRepository vehicleRepository;

    public Readings storeReadings(Readings readings) {
        Optional<Vehicle> existing = vehicleRepository.findById(readings.getVin());
        System.out.println(readings.getVin());

        if (!existing.isPresent()) {
            throw new ResourceNotFoundException("Vehicle with id " + readings.getVin() + " doesn't exist.");
        }
        System.out.println(readings.getVin());
        return repository.save(readings);
    }
}
