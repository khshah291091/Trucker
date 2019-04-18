package com.ennet.trucker.repository;

import com.ennet.trucker.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    Vehicle findByVin(String vin);
    boolean deleteVehiclesByVin(String vin);
    void deleteAll();

}
