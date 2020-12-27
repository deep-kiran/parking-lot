package com.company.services;

import com.company.models.*;
import com.company.models.vehicles.Vehicle;

public interface ParkingService {

    boolean canFit(ParkingLot parkingLot, Vehicle vehicle);

    void assignTicket(Vehicle vehicle);
}
