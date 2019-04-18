package com.ennet.trucker.repository;

import com.ennet.trucker.entity.Reading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingRepository extends JpaRepository<Reading, String> {
    boolean deleteByVin(String vin);
}
