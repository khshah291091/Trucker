package com.ennet.trucker.service;

import com.ennet.trucker.Exception.ResourceNotFoundException;
import com.ennet.trucker.entity.Vehicles;
import com.ennet.trucker.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    VehicleRepository repository;

    public List<Vehicles> findAll() {
        List<Vehicles> vehicles = repository.findAll();
        if(vehicles == null){
            throw new ResourceNotFoundException("No Records Found");
        }
        return repository.findAll();
    }

    public Vehicles findByVin(String vin) {
        Vehicles vehicle = repository.findByVin(vin);
        if(vehicle == null){
            throw new ResourceNotFoundException("No record found with the vin : "+ vin);
        }
        return vehicle;
    }

    @Transactional
    public Vehicles create(Vehicles vehicle) {
        return repository.save(vehicle);
    }

    @Transactional
    public List<Vehicles> update(List<Vehicles> vehicles) {

        for(Vehicles vehicle : vehicles){
            Vehicles exists = repository.findByVin(vehicle.getVin());
            if(exists == null){
                repository.save(vehicle);
            }
            else {
                repository.saveAll(vehicles);
            }
        }
        return vehicles;
    }

    @Transactional
    public void delete(String vin) {
        Vehicles vehicle = repository.findByVin(vin);
        if(vehicle!=null){
            repository.delete(vehicle);
        }
        else{
            throw new ResourceNotFoundException("No Vehicle found of given vin");
        }
    }
}
