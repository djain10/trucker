package com.trukcer.controller;

import com.trukcer.entity.Alert;
import com.trukcer.entity.Vehicle;
import com.trukcer.service.VehicleService;
import com.trukcer.service.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

    @Autowired
    VehicleService service;

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> create(@RequestBody List<Vehicle> vehicles){

        return service.create(vehicles);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> findAll() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET,  value = "/{vin}/alerts", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Alert> findAlertByVechicleId(@PathVariable("vin")  String vin){
        return service.findAlertByVechicleId(vin);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}/locations", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Map<String,String>> findLocationByVehicleId(@PathVariable("vin") String vin){
        return service.findLocationByVehicleId(vin);
    }

    @RequestMapping(method = RequestMethod.GET,  value = "/all/alerts/high", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Alert> findHighAlertOfAllVehicle(){
        return service.findHighAlertOfAllVehicle();
    }
}
