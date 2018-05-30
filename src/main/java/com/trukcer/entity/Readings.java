package com.trukcer.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

@Entity
public class Readings {

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;
    Vehicle vin;
    String latitude;
    String longitude;
    String timestamp;
    double fuelVolume;
    int speed;
    int engineHp;
    boolean checkEngineLightOn;
    boolean engineCoolantLow;
    int engineRpm;
    @OneToOne
    Tires tires;

    private Readings() {
        this.id = UUID.randomUUID()
                .toString();
    }

    private String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    private Vehicle getVin() {
        return vin;
    }

    private void setVin(Vehicle vin) {
        this.vin = vin;
    }

    private String getLatitude() {
        return latitude;
    }

    private void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    private String getLongitude() {
        return longitude;
    }

    private void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    private String getTimestamp() {
        return timestamp;
    }

    private void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    private double getFuelVolume() {
        return fuelVolume;
    }

    private void setFuelVolume(double fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    private int getSpeed() {
        return speed;
    }

    private void setSpeed(int speed) {
        this.speed = speed;
    }

    private int getEngineHp() {
        return engineHp;
    }

    private void setEngineHp(int engineHp) {
        this.engineHp = engineHp;
    }

    private boolean isCheckEngineLightOn() {
        return checkEngineLightOn;
    }

    private void setCheckEngineLightOn(boolean checkEngineLightOn) {
        this.checkEngineLightOn = checkEngineLightOn;
    }

    private boolean isEngineCoolantLow() {
        return engineCoolantLow;
    }

    private void setEngineCoolantLow(boolean engineCoolantLow) {
        this.engineCoolantLow = engineCoolantLow;
    }

    private int getEngineRpm() {
        return engineRpm;
    }

    private void setEngineRpm(int engineRpm) {
        this.engineRpm = engineRpm;
    }

    private Tires getTires() {
        return tires;
    }

    private void setTires(Tires tires) {
        this.tires = tires;
    }
}
