package com.ennet.trucker.controller;

import com.ennet.trucker.entity.Reading;
import com.ennet.trucker.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/readings")
public class ReadingController {


    @Autowired
    ReadingService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Reading> getAllReadings(){
        return service.getAllReadings();
    }
    @RequestMapping(method = RequestMethod.POST)
    public Reading create(@RequestBody Reading reading){
        return service.create(reading);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/{vin}")
    public boolean delete(@PathVariable String vin){
        return service.deleteReading(vin);
    }
}
