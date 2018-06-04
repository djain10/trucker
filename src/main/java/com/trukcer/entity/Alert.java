package com.trukcer.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Alert {

    @Id
    private String id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Vehicle vehicle;
    private String message;
    private AlertType type;
    @CreationTimestamp
    private LocalDateTime time;

    public Alert() {
        this.id = UUID.randomUUID().toString();
        this.time = LocalDateTime.now();
    }

    public Alert(Vehicle vehicle, String message, AlertType type) {
        this.id = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.message = message;
        this.type = type;
        this.time = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AlertType getType() {
        return type;
    }

    public void setType(AlertType type) {
        this.type = type;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
