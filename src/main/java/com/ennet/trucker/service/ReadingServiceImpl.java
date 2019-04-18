package com.ennet.trucker.service;

import com.ennet.trucker.entity.Alert;
import com.ennet.trucker.entity.Priority;
import com.ennet.trucker.entity.Reading;
import com.ennet.trucker.entity.Vehicle;
import com.ennet.trucker.repository.AlertRepository;
import com.ennet.trucker.repository.ReadingRepository;
import com.ennet.trucker.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadingServiceImpl implements ReadingService {
    @Autowired
    ReadingRepository repository;

    @Autowired
    AlertRepository alertRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    public List<Reading> getAllReadings(){
        return repository.findAll();
    }

    public Reading create(Reading reading) {

        System.out.println("-------Here--------");
        Vehicle vehicle = vehicleRepository.findByVin(reading.getVin());
        if(vehicle!=null){
                createAlert(reading,vehicle);
        }
        return repository.save(reading);
    }

    public boolean deleteReading(String vin){
        if(repository.findById(vin) != null){
            repository.deleteByVin(vin);
            return true;
        }
        else{
            return false;
        }
    }

    public void createAlert(Reading readings, Vehicle vehicles){
        if(readings.getEngineRpm() > vehicles.getRedlineRpm()){
            Alert alert = new Alert(vehicles.getVin(),"engineRpm > readlineRpm", Priority.HIGH);
            alertRepository.save(alert);

        }
        if(readings.getFuelVolume() < ((0.1) * readings.getFuelVolume())){
            Alert alert = new Alert(vehicles.getVin(),"fuelVolume < 10% of maxFuelVolume", Priority.MEDIUM);
            alertRepository.save(alert);

        }
        if(readings.getTires().getFrontLeft() < 32 || readings.getTires().getFrontLeft() > 36 ||
                readings.getTires().getFrontRight() < 32 || readings.getTires().getFrontRight() > 36 ||
                readings.getTires().getRearLeft() < 32 || readings.getTires().getRearLeft() > 36 ||
                readings.getTires().getRearRight() < 32 || readings.getTires().getRearRight() > 36){

            Alert alert = new Alert(vehicles.getVin(),"Tire Pressure", Priority.LOW);
            alertRepository.save(alert);
        }
        if(readings.isEngineCoolantLow() == true || readings.isCheckEngineLightOn() == true) {
            Alert alert = new Alert(vehicles.getVin(), "Engine Coolant & Engine Light", Priority.LOW);
            alertRepository.save(alert);
        }
    }


}
