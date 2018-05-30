package com.trukcer.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehicle {

    @Id
    String vin;
    String make;
    String model;
    int year;
    int redlineRpm;
    int maxFuelVolume;
    String lastServiceDate;

    private String getVin() {
        return vin;
    }

    private void setVin(String vin) {
        this.vin = vin;
    }

    private String getMake() {
        return make;
    }

    private void setMake(String make) {
        this.make = make;
    }

    private String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    private int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    private int getRedlineRpm() {
        return redlineRpm;
    }

    private void setRedlineRpm(int redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    private int getMaxFuelVolume() {
        return maxFuelVolume;
    }

    private void setMaxFuelVolume(int maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    private String getLastServiceDate() {
        return lastServiceDate;
    }

    private void setLastServiceDate(String lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vin='" + vin + '\'' +
                ", make='" +  make + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", redlineRpm='" + redlineRpm + '\'' +
                ", maxFuelVolume='" + maxFuelVolume + '\'' +
                ", lastServiceDate='" + lastServiceDate + '\'' +
                '}';
    }
}