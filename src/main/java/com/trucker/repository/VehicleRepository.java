package com.trucker.repository;

import com.trucker.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, String> {

    public List<Vehicle> findAll();
}
