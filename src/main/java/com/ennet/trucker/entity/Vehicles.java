package com.ennet.trucker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehicles {

    @Id
    private String vin;
    private String make;
    private String model;
    private String year;
    private int redlineRpm;
    private float maxFuelVolume;
    private String lastServiceDate;


    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(int redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public float getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(float maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public String getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(String lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    @Override
    public String toString() {
        return "Vehicles{" +
                "vin='" + vin + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", redlineRpm=" + redlineRpm +
                ", maxFuelVolume=" + maxFuelVolume +
                ", lastServiceDate='" + lastServiceDate + '\'' +
                '}';
    }
}
