package com.ennet.trucker.service;

import com.ennet.trucker.entity.Alert;
import com.ennet.trucker.entity.Priority;

import java.util.List;

public interface AlertService {
    List<Alert> getAllAlerts();
    List<Alert> getAlertForVin(String vin);
    List<Alert> getAlertsByPriority(Priority priority);
    Alert create(Alert alert);
}
