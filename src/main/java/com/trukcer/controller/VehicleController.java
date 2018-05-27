package com.trukcer.controller;

import com.trukcer.entity.Vehicle;
import com.trukcer.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {
    @Autowired
    VehicleService service;

    @RequestMapping(method = RequestMethod.PUT)
    public Vehicle vehicleDetails(@RequestBody Vehicle vehicle){
        return service.vehicleDetais();
    }
}
