package com.ennet.trucker.controller;

import com.ennet.trucker.entity.Vehicles;
import com.ennet.trucker.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://mocker.ennate.academy/", maxAge = 3600)
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    VehicleService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Vehicles>  findAll(){
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}")
    public Vehicles findOne(@PathVariable("vin") String vin) {
        return service.findByVin(vin);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Vehicles create(@RequestBody Vehicles vehicle){
        System.out.println(vehicle);
        return service.create(vehicle);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public List<Vehicles> update(@RequestBody List<Vehicles> vehicles){
        return service.update(vehicles);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/remove/{vin}")
    public void delete(@PathVariable("vin") String vin){
        service.delete(vin);
    }



}