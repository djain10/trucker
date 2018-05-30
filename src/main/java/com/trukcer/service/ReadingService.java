package com.trukcer.service;

import com.trukcer.entity.Readings;
import org.springframework.data.repository.CrudRepository;

public interface ReadingService {
    Readings storeReadings(Readings readings);
}
