package com.trucker.repository;

import com.trucker.entity.Alert;
import com.trucker.entity.Vehicle;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AlertRespository extends CrudRepository<Alert, String> {
    List<Alert> findByVehicle(Vehicle vehicle);

    @Query("select alert from Alert alert where alert.type = 0 and alert.time between  :from and :to order by alert.time, alert.vehicle.vin")
    List<Alert> findByVehicleAndTypeEqualsHigh(@Param("from") @CreationTimestamp LocalDateTime from, @Param("to") @CreationTimestamp LocalDateTime to);

}
