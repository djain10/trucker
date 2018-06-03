package com.trukcer.service;

import com.trukcer.entity.Readings;
import org.springframework.data.repository.CrudRepository;

public interface ReadingService {
    void storeReadings(Readings readings);
}
