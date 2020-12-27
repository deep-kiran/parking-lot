package com.company.services;

import com.company.models.ParkingLot;
import com.company.models.ParkingTicket;
import com.company.models.vehicles.Vehicle;

public class ParkingServiceImpl implements ParkingService{
    @Override
    public boolean canFit(ParkingLot parkingLot, Vehicle vehicle) {
        return parkingLot.isFull(vehicle);
    }

    @Override
    public void assignTicket(Vehicle vehicle) {
        vehicle.assignTicket(new ParkingTicket());
    }
}
