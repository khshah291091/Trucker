package com.ennet.trucker.service;

import com.ennet.trucker.entity.Alert;
import com.ennet.trucker.entity.Priority;
import com.ennet.trucker.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertServiceImpl implements AlertService{

    @Autowired
    AlertRepository alertRepository;
    public List<Alert> getAllAlerts() {
        return alertRepository.findAll();
    }

    public List<Alert> getAlertForVin(String vin) {
        return alertRepository.getAlertByVin(vin);
    }

    public List<Alert> getAlertsByPriority(Priority priority) {
        return alertRepository.getAlertByPriorityType(priority);
    }

    public Alert create(Alert alert) {
        return alertRepository.save(alert);
    }
}
