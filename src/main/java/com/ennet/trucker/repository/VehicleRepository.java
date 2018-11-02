package com.ennet.trucker.repository;

import com.ennet.trucker.entity.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicles, String> {
    Vehicles findByVin(String vin);
}
