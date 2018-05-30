package com.trukcer.service;

import com.trukcer.entity.Readings;
import com.trukcer.entity.Vehicle;
import com.trukcer.repository.ReadingRepository;
import com.trukcer.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    ReadingRepository repository;
    @Autowired
    VehicleRepository vehicleRepository;

    public Readings storeReadings(Readings readings) {
        List<Vehicle> existing = vehicleRepository.findAll();
        System.out.println(readings.getVin());
        for (Vehicle v : existing) {
            if (v.getVin().equals(readings.getVin())) {
                System.out.println(v.getVin());
                System.out.println(readings.getVin());
                return repository.save(readings);
            }
        }
        return null;
    }
}
