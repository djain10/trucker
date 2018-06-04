package com.trukcer.service;

import com.trukcer.alert.Alert1;
import com.trukcer.alert.Alert2;
import com.trukcer.alert.Alert3;
import com.trukcer.alert.Alert4;
import com.trukcer.entity.Readings;
import com.trukcer.entity.Vehicle;
import com.trukcer.exception.ResourceNotFoundException;
import com.trukcer.repository.AlertRespository;
import com.trukcer.repository.VehicleRepository;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RulesEngineParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class AlertServiceImpl implements AlertService {

    @Autowired
   private AlertRespository repository;
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    @Transactional
    public void createAlert(Readings readings) {
        Optional<Vehicle> existing = vehicleRepository.findById(readings.getVin().getVin());
        if(!existing.isPresent()){
            throw new ResourceNotFoundException("Vehicle id:" + readings.getVin().getVin() + "not found." );
        }
        readings.setVin(existing.get());

        RulesEngineParameters parameters = new RulesEngineParameters();
        RulesEngine rulesEngine = new DefaultRulesEngine(parameters);
        Rules rules = new Rules();
        rules.register(new Alert1());
        rules.register(new Alert2());
        rules.register(new Alert3());
        rules.register(new Alert4());


        Facts facts = new Facts();
        facts.put("vehicle", existing.get());
        facts.put("readings", readings);
        facts.put("repository",repository);
        rulesEngine.fire(rules,facts);

    }
}
