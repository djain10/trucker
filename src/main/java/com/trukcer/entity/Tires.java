package com.trukcer.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Tires {

    @Id
    private String id;
    private int frontLeft;
    private int frontRight;
    private int rearLeft;
    private int rearRight;

    public Tires() {
        this.id = UUID.randomUUID()
                .toString();
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
