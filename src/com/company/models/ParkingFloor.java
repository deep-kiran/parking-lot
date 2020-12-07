package com.company.models;

import com.company.exceptions.SlotNotPresentException;
import com.company.models.actors.ParkingAttendant;
import com.company.models.parkingslots.*;
import com.company.models.vehicles.Vehicle;

import java.util.HashMap;
import java.util.HashSet;

public class ParkingFloor extends Auditable {
    private String parkingLevel;

    HashMap<ParkingSlotType, HashSet<ParkingSlot>> parkingSlots;
    HashMap<ParkingSlotType, HashSet<ParkingSlot>> occupiedSlots;

    public ParkingFloor(String parkingLevel) {
        this.parkingLevel = parkingLevel;
    }

    public boolean isFull(ParkingSlotType type) {
        return (parkingSlots.size()==0);
    }
    public void populateMap(ParkingSlot slot){
        if (!parkingSlots.containsKey(slot.getType()))
            parkingSlots.put(slot.getType(), new HashSet<>());
        if(!occupiedSlots.containsKey(slot.getType())){
            occupiedSlots.put(slot.getType(), new HashSet<>());
        }
    }

    public void addParkingSpot(ParkingSlot slot) {
       populateMap(slot);
        parkingSlots.get(slot.getType()).add(slot);
    }

    public void removeParkingSpot(ParkingSlot slot) throws SlotNotPresentException {
        populateMap(slot);
        if(!parkingSlots.get(slot.getType()).contains(slot)){
            throw new SlotNotPresentException(" Slot needs to be added first so that it can be removed");
        }
       parkingSlots.get(slot.getType()).remove(slot);
       occupiedSlots.get(slot.getType()).remove(slot);
    }
    public void assignVehicleToSpot(Vehicle vehicle, ParkingSlot slot) {
       slot.parkVehicle(vehicle);
       occupiedSlots.get(slot.getType()).add(slot);
       parkingSlots.get(slot.getType()).remove(slot);

    }
    public void removeVehicleFromSpot(Vehicle vehicle, ParkingSlot slot) throws SlotNotPresentException {
        populateMap(slot);
        if(!occupiedSlots.get(slot.getType()).contains(slot)){
            throw new SlotNotPresentException(" Slot needs to be added first so that it can be removed");
        }
        slot.unparkVehicle(vehicle);
        parkingSlots.get(slot.getType()).add(slot);
        occupiedSlots.get(slot.getType()).remove(slot);
    }

    public void getFreeSlots() {
        StringBuilder sb =new StringBuilder();
        for(ParkingSlotType type : parkingSlots.keySet()){
            sb.append(type).append("-->");
            for(ParkingSlot slot : parkingSlots.get(type)){
                sb.append(slot.toString()).append("  ");
            }
            sb.append("\n");
        }
        DisplayBoard.display(sb.toString());
    }

    public void removeExitPoint(ExitPoint point) {
    }
}
