package com.trukcer.repository;

import com.trukcer.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleRepository extends CrudRepository<Vehicle, String> {

    public List<Vehicle> findAll();
}
