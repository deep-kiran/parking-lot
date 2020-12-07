package com.company.models;

import com.company.models.actors.ParkingAttendant;
import com.company.models.parkingslots.ParkingSlotType;
import com.company.models.vehicles.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ParkingLot extends Auditable{
    public static int fineRate;
    public static int rate;
    Address address;
    private static ArrayList<ParkingFloor> parkingFloors;

    private static HashMap<VehicleType,ParkingSlotType> vehicleToParkingSlotMap;
    private static HashSet<ParkingTicket> activeTickets;
    private static HashSet<Gate>gates;

    public static ArrayList<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }



    public static boolean removeActiveTicket(String ticketNumber){
        activeTickets.remove(ticketNumber);
        return true;
    }

    ParkingLot(){
        vehicleToParkingSlotMap =new HashMap<>();
        parkingFloors =new ArrayList<>();
        activeTickets=new HashSet<>();
    }
   public static boolean isFull(ParkingSlotType type){
        for(ParkingFloor floor : parkingFloors){
            if(!floor.isFull(type)){
                return false;
            }
        }
        return true;
    }


    public static void addParkingFloor(ParkingFloor floor) {

        parkingFloors.add(floor);
    }

    public static void addParkingAttendant(ParkingAttendant attendant) {

    }

    public static void addEntrancePanel( EntrancePoint point) {
        gates.add(point);
    }

    public static void addExitPanel(ExitPoint point) {
        gates.add(point);
    }
    public static void removeExitPanel(ExitPoint point) {
            gates.remove(point);
    }

    public static void removeEntrancePanel(EntrancePoint point) {
        gates.remove(point);
    }
}
