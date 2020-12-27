package com.company.services;

import com.company.exceptions.NoSuchParkingLotPresent;
import com.company.models.*;
import com.company.models.actors.ParkingAttendant;
import com.company.models.actors.ParkingLotSystem;

import java.util.HashMap;
import java.util.UUID;

public class InMemoryAdminServiceImpl implements AdminService{
    HashMap<UUID,ParkingLot> parkingLotHashMap =new HashMap<>();
    @Override
    public ParkingLot createParkingLot(Address address) {
        ParkingLot parkingLot =new ParkingLot(address);
        parkingLotHashMap.put(UUID.randomUUID(),parkingLot);
        return parkingLot;
    }

    @Override
    public ParkingAttendant createParkingAttendant(String name, String email) {
        ParkingAttendant attendant = new ParkingAttendant();
        attendant.setName(name);
        attendant.setEmail(email);
        return attendant;
    }

    @Override
    public void addParkingFloor(ParkingLot parkingLot, ParkingFloor floor) {
        if (!parkingLotHashMap.containsKey(parkingLot.getId())){
            throw new NoSuchParkingLotPresent("Parking lot is not created");
        }
        parkingLot.addParkingFloor(floor);
    }

    @Override
    public void addParkingAttendant(ParkingLot parkingLot, Gate gate, ParkingAttendant attendant) {
        if (!parkingLotHashMap.containsKey(parkingLot.getId())){
            throw new NoSuchParkingLotPresent("Parking lot is not created");
        }
        parkingLot.addParkingAttendant(gate, attendant);
        ParkingLotSystem.print("ParkingAttendant " + attendant.toString() +"added to gate" +gate.toString());
    }

    @Override
    public void addEntrancePanel(ParkingLot parkingLot, EntrancePoint point) {
        if (!parkingLotHashMap.containsKey(parkingLot.getId())){
            throw new NoSuchParkingLotPresent("Parking lot is not created");
        }
        parkingLot.addEntrancePanel(point);
    }

    @Override
    public void removeEntrancePanel(ParkingLot parkingLot, EntrancePoint point) {
        if (!parkingLotHashMap.containsKey(parkingLot.getId())){
            throw new NoSuchParkingLotPresent("Parking lot is not created");
        }
        parkingLot.removeEntrancePanel(point);
    }

    @Override
    public void addExitPanel(ParkingLot parkingLot, ExitPoint point) {
        if (!parkingLotHashMap.containsKey(parkingLot.getId())){
            throw new NoSuchParkingLotPresent("Parking lot is not created");
        }
        parkingLot.addExitPanel(point);
    }

    @Override
    public void removeExitPanel(ParkingLot parkingLot, ExitPoint point) {
        if (!parkingLotHashMap.containsKey(parkingLot.getId())){
            throw new NoSuchParkingLotPresent("Parking lot is not created");
        }
        parkingLot.removeExitPanel(point);
    }
}
