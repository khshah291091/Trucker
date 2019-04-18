package com.ennet.trucker.controller;

import com.ennet.trucker.entity.Alert;
import com.ennet.trucker.entity.Priority;
import com.ennet.trucker.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/alerts")
public class AlertController {
    @Autowired
    AlertService alertService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Alert> findAllAlert(){
        return alertService.getAllAlerts();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}")
    public List<Alert> findAlertByVin(@PathVariable String vin){
        return alertService.getAlertForVin(vin);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/priority/{priority}")
    public List<Alert> findAlertByPriority(@PathVariable Priority priority){
        return alertService.getAlertsByPriority(priority);
    }


}
