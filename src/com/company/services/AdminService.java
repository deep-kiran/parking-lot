package com.company.services;

import com.company.models.*;
import com.company.models.actors.ParkingAttendant;

public interface AdminService {
    ParkingLot createParkingLot(Address address);

    ParkingAttendant createParkingAttendant(String name, String email);

    void addParkingFloor(ParkingLot parkingLot, ParkingFloor floor);

    void addParkingAttendant(ParkingLot parkingLot, Gate gate, ParkingAttendant attendant);

    void addEntrancePanel(ParkingLot parkingLot, EntrancePoint point);

    void removeEntrancePanel(ParkingLot parkingLot, EntrancePoint point);

    void addExitPanel(ParkingLot parkingLot, ExitPoint point);

    void removeExitPanel(ParkingLot parkingLot, ExitPoint point);

}
