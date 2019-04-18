package com.ennet.trucker.service;

import com.ennet.trucker.entity.Reading;
import com.ennet.trucker.entity.Vehicle;

import java.util.List;

public interface ReadingService {
    List<Reading> getAllReadings();
    Reading create(Reading reading);
    boolean deleteReading(String vin);
    void createAlert(Reading readings, Vehicle vehicles);
}
