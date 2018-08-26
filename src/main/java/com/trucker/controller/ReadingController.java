package com.trucker.controller;

import com.trucker.entity.Readings;
import com.trucker.service.AlertService;
import com.trucker.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/readings")
public class ReadingController {

    @Autowired
    ReadingService service;
    @Autowired
    AlertService alertService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void storeReadings(@RequestBody Readings readings){
         service.storeReadings(readings);
         alertService.createAlert(readings);
    }

}
