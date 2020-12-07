package com.company.models.vehicles;

import com.company.models.ParkingTicket;

public abstract class Vehicle {
    String licenseNo;
    private VehicleType type;
    ParkingTicket ticket;

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public ParkingTicket getTicket() {
        return ticket;
    }

    public void setTicket(ParkingTicket ticket) {
        this.ticket = ticket;
    }

    public Vehicle(VehicleType type){
        this.type=type;
    }
    public void assignTicket(ParkingTicket ticket){
        this.ticket =ticket;
    }
}
