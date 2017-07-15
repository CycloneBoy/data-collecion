package com.cycloneboy.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 头盔采集信息实体
 * Created by CycloneBoy on 2017/7/15.
 */
@Entity
@Table(name = "t_helmet")
public class Helmet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private double temperature;

    private double originalLongitude;

    private double originalLatitude;

    private double inertialNavigation;

    private double calibrationLongitude;

    private double calibrationLatitude;

    private double ecgSignal;

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

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getOriginalLongitude() {
        return originalLongitude;
    }

    public void setOriginalLongitude(double originalLongitude) {
        this.originalLongitude = originalLongitude;
    }

    public double getOriginalLatitude() {
        return originalLatitude;
    }

    public void setOriginalLatitude(double originalLatitude) {
        this.originalLatitude = originalLatitude;
    }

    public double getInertialNavigation() {
        return inertialNavigation;
    }

    public void setInertialNavigation(double inertialNavigation) {
        this.inertialNavigation = inertialNavigation;
    }

    public double getCalibrationLongitude() {
        return calibrationLongitude;
    }

    public void setCalibrationLongitude(double calibrationLongitude) {
        this.calibrationLongitude = calibrationLongitude;
    }

    public double getCalibrationLatitude() {
        return calibrationLatitude;
    }

    public void setCalibrationLatitude(double calibrationLatitude) {
        this.calibrationLatitude = calibrationLatitude;
    }

    public double getEcgSignal() {
        return ecgSignal;
    }

    public void setEcgSignal(double ecgSignal) {
        this.ecgSignal = ecgSignal;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
