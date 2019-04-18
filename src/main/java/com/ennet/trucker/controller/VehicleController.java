package com.ennet.trucker.controller;

import com.ennet.trucker.entity.Vehicle;
import com.ennet.trucker.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://mocker.ennate.academy/", maxAge = 3600)
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Qualifier("vehicleServiceImpl")
    @Autowired
    VehicleService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Vehicle>  findAll(){
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}")
    public Vehicle findOne(@PathVariable("vin") String vin) {
        return service.findByVin(vin);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Vehicle create(@RequestBody Vehicle vehicle){
        System.out.println(vehicle);
        return service.create(vehicle);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public List<Vehicle> update(@RequestBody List<Vehicle> vehicles){
        return service.update(vehicles);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/remove/{vin}")
    public boolean deleteVehiclesByVin(@PathVariable("vin") String vin){
        return service.deleteVehiclesByVin(vin);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteAll")
    public void deleteAll(){
        service.deleteAll();
    }



}