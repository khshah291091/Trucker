package com.ennet.trucker.service;

import com.ennet.trucker.Exception.ResourceNotFoundException;
import com.ennet.trucker.entity.Vehicle;
import com.ennet.trucker.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    VehicleRepository repository;

    public List<Vehicle> findAll() {
        List<Vehicle> vehicles = repository.findAll();
        if(vehicles.size() == 0){
            throw new ResourceNotFoundException("No Records Found");
        }
        return repository.findAll();
    }

    public Vehicle findByVin(String vin) {
        Vehicle vehicle = repository.findByVin(vin);
        if(vehicle == null){
            throw new ResourceNotFoundException("No record found with the vin : "+ vin);
        }
        return vehicle;
    }

    @Transactional
    public Vehicle create(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    @Transactional
    public List<Vehicle> update(List<Vehicle> vehicles) {

        for(Vehicle vehicle : vehicles){
            /*Vehicle exists = repository.findByVin(vehicle.getVin());
            if(exists == null){
                repository.save(vehicle);
            }
            else {
                repository.saveAll(vehicles);
            }*/
            repository.saveAll(vehicles);
        }
        return vehicles;
    }

    @Transactional
    public boolean deleteVehiclesByVin(String vin) {
        if(repository.findByVin(vin)!=null){
            repository.deleteVehiclesByVin(vin);
        }
        else{
            throw new ResourceNotFoundException("No Vehicle found of given vin");
        }
        return true;
    }

    @Transactional
    public void deleteAll(){
        repository.deleteAll();
        System.out.println("Deleted All vehicles");
    }
}
