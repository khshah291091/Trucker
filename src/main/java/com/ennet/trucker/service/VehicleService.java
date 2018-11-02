package com.ennet.trucker.service;

import com.ennet.trucker.entity.Vehicles;

import java.util.List;

public interface VehicleService {
    List<Vehicles> findAll();
    Vehicles findByVin(String vin);
    Vehicles create(Vehicles vehicle);
    List<Vehicles> update(List<Vehicles> vehicle);
    void delete(String vin);
}
