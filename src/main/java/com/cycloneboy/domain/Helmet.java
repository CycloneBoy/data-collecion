package com.cycloneboy.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by CycloneBoy on 2017/7/15.
 */
@Entity
@Table(name = "t_helmet")
public class Helmet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private float temperature;

    private float originalLongitude;

    private float originalLatitude;

    private float inertialNavigation;

    private float calibrationLongitude;

    private float calibrationLatitude;

    private float ecgSignal;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getOriginalLongitude() {
        return originalLongitude;
    }

    public void setOriginalLongitude(float originalLongitude) {
        this.originalLongitude = originalLongitude;
    }

    public float getOriginalLatitude() {
        return originalLatitude;
    }

    public void setOriginalLatitude(float originalLatitude) {
        this.originalLatitude = originalLatitude;
    }

    public float getInertialNavigation() {
        return inertialNavigation;
    }

    public void setInertialNavigation(float inertialNavigation) {
        this.inertialNavigation = inertialNavigation;
    }

    public float getCalibrationLongitude() {
        return calibrationLongitude;
    }

    public void setCalibrationLongitude(float calibrationLongitude) {
        this.calibrationLongitude = calibrationLongitude;
    }

    public float getCalibrationLatitude() {
        return calibrationLatitude;
    }

    public void setCalibrationLatitude(float calibrationLatitude) {
        this.calibrationLatitude = calibrationLatitude;
    }

    public float getEcgSignal() {
        return ecgSignal;
    }

    public void setEcgSignal(float ecgSignal) {
        this.ecgSignal = ecgSignal;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
