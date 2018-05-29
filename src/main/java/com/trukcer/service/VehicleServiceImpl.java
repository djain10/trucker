package com.trukcer.service;

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
    public void create(List <Vehicle> vehicles) {
           vehicles = new ArrayList<Vehicle>();

           /*for(int i =0; i < vehicles.size(); i++){
               repository.save(vehicles.get(i));
           }*/
        for(Vehicle v : vehicles){
                repository.save(v);
        }
           // return repository.findAll();
    }


    public List<Vehicle> findAll() {
        return repository.findAll();
    }
}
