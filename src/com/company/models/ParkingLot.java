package com.company.models;

import com.company.models.actors.ParkingAttendant;
import com.company.models.parkingslots.ParkingSlotType;
import com.company.models.vehicles.Vehicle;
import com.company.models.vehicles.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ParkingLot extends Auditable{
    private static int fineRate;
    private static int rate;
    private final Address address;
    private static ArrayList<ParkingFloor> parkingFloors =new ArrayList<>();
    private static HashSet<ParkingTicket> activeTickets;
    private static HashSet<Gate>gates;

    public static ArrayList<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }



    public static boolean removeActiveTicket(String ticketNumber){
        activeTickets.remove(ticketNumber);
        return true;
    }

    public ParkingLot(Address address){
        this.address =address;
        parkingFloors =new ArrayList<>();
        activeTickets=new HashSet<>();
    }
   public  boolean isFull(Vehicle vehicle){
        for(ParkingFloor floor : parkingFloors){
            for(ParkingSlotType slotType : vehicle.getType().getFitsIn() )
                if(!floor.isFull(slotType)){
                    return false;
                }
        }
        return true;
    }


    public  void addParkingFloor(ParkingFloor floor) {

        parkingFloors.add(floor);
    }

    public  void addParkingAttendant(Gate gate,ParkingAttendant attendant) {
        gate.setParkingAttendant(attendant);
        attendant.setGate(gate);
    }
    public  void removeParkingAttendant(ParkingAttendant attendant) {
        Gate gate = attendant.getGate();
        gate.setParkingAttendant(null);
    }


    public  void addEntrancePanel( EntrancePoint point) {
        gates.add(point);
    }

    public  void addExitPanel(ExitPoint point) {
        gates.add(point);
    }
    public  void removeExitPanel(ExitPoint point) {
            gates.remove(point);
    }

    public  void removeEntrancePanel(EntrancePoint point) {
        gates.remove(point);
    }
}
