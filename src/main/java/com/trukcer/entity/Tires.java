package com.trukcer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity

public class Tires {

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    String id;
    int frontLeft;
    int frontRight;
    int rearLeft;
    int rearRight;

    public Tires() {
        this.id = UUID.randomUUID()
                .toString();
    }

    private String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    private int getFrontLeft() {
        return frontLeft;
    }

    private void setFrontLeft(int frontLeft) {
        this.frontLeft = frontLeft;
    }

    private int getFrontRight() {
        return frontRight;
    }

    private void setFrontRight(int frontRight) {
        this.frontRight = frontRight;
    }

    private int getRearLeft() {
        return rearLeft;
    }

    private void setRearLeft(int rearLeft) {
        this.rearLeft = rearLeft;
    }

    private int getRearRight() {
        return rearRight;
    }

    private void setRearRight(int rearRight) {
        this.rearRight = rearRight;
    }
}
