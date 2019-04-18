package com.ennet.trucker.service;

import com.ennet.trucker.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> findAll();
    Vehicle findByVin(String vin);
    Vehicle create(Vehicle vehicle);
    List<Vehicle> update(List<Vehicle> vehicle);
    boolean deleteVehiclesByVin(String vin);
    void deleteAll();
}
