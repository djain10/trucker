package com.trukcer.repository;

import com.trukcer.entity.Readings;
import com.trukcer.entity.Vehicle;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Repository
public interface ReadingRepository extends CrudRepository<Readings, String> {

    @Query("select latitude as latitude,longitude as longitude from Readings readings where readings.timestamp between  :from  and :to and readings.vin = :vin ")
   public List<Map<String,String>> findLocationByVehicle(@Param("from") @CreationTimestamp LocalDateTime from, @Param("to") @CreationTimestamp LocalDateTime to, @Param("vin") Vehicle vin);
}
