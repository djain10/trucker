package com.trukcer.controller;

import com.trukcer.entity.Alert;
import com.trukcer.entity.Vehicle;
import com.trukcer.service.VehicleService;
import com.trukcer.service.VehicleServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/vehicles")
@Api(description = "Vehicle related endpoints")
public class VehicleController {

    @Autowired
    VehicleService service;

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> create(@RequestBody List<Vehicle> vehicles){

        return service.create(vehicles);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/all",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Find All Vehicle",
            notes = "Returns a list of all vehicles avaialble in the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public List<Vehicle> findAll() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET,  value = "/{vin}/alerts", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Find Alert of Vehicle by ID",
            notes = "Return alerts of  vehicle or throws 404")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public List<Alert> findAlertByVechicleId(@PathVariable("vin")  String vin){
        return service.findAlertByVechicleId(vin);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}/locations", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Find Location of Vehicle by ID",
            notes = "Return location of  vehicle or throws 404")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public List<Map<String,String>> findLocationByVehicleId(@PathVariable("vin") String vin){
        return service.findLocationByVehicleId(vin);
    }

    @RequestMapping(method = RequestMethod.GET,  value = "/all/alerts/high", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Find High Alerts of All Vehicle",
            notes = "Return high alerts of all vehicle or throws 404")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public List<Alert> findHighAlertOfAllVehicle(){
        return service.findHighAlertOfAllVehicle();
    }
}
