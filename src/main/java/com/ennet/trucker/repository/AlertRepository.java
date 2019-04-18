package com.ennet.trucker.repository;

import com.ennet.trucker.entity.Alert;
import com.ennet.trucker.entity.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertRepository extends JpaRepository<Alert, String> {

    List<Alert> getAlertByVin(String vin);
    List<Alert> getAlertByPriorityType(Priority priority);
}
