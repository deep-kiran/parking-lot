package com.company.models.parkingslots;

import com.company.models.Auditable;
import com.company.models.vehicles.Vehicle;

public abstract class ParkingSlot extends Auditable {
    int number;

    @Override
    public String toString() {
        return "ParkingSlot{" +
                "number=" + number +
                ", type=" + type +
                ", isFree=" + isFree +
                ", vehicle=" + vehicle +
                '}';
    }

    ParkingSlotType type;
    private boolean isFree;
    Vehicle vehicle;

    public ParkingSlot(ParkingSlotType type, int number){
        this.type =type;
        this.isFree=false;
        this.number =number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ParkingSlotType getType() {
        return type;
    }

    public void setType(ParkingSlotType type) {
        this.type = type;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isFree() {
        return this.isFree;
    }

    public boolean parkVehicle(Vehicle vehicle){
        this.vehicle =vehicle;
        this.isFree =false;
        return true;
    }
    public boolean unparkVehicle(Vehicle vehicle){
        this.vehicle=null;
        this.isFree=true;
        return true;
    }


}
