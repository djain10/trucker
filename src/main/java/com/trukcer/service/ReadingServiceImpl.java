package com.trukcer.service;

import com.trukcer.entity.Readings;
import com.trukcer.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    ReadingRepository repository;
    public void storeReadings(Readings readings) {
        repository.save(readings);

    }
}
