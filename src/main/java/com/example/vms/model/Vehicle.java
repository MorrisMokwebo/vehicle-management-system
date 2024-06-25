package com.example.vms.model;

import jakarta.annotation.Generated;

public class Vehicle {

    private long id;
    private String make;
    private String model;
    private String year;
    private String transmissionType;



    public Vehicle(long id, String make, String model, String year, String transmissionType) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.transmissionType = transmissionType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }
}
