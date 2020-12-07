package com.company.models.actors;

import com.company.models.*;

public class Admin extends Person {

    public  void setHourlyRate(int r){
    }
    public  int getRate() {
        return Constants.getRate();
    }
    public  void setFineRate(int fineRate){
        Constants.setFineRate(fineRate);
    }
    public int getFineRate() {
        return Constants.getFineRate();
    }

    public void addParkingFloor(ParkingFloor floor){
        ParkingLot.addParkingFloor(floor);
    }
    public void addParkingAttendant(Gate gate,ParkingAttendant attendant){
        ParkingLot.addParkingAttendant(gate,attendant);
        return ;
    }
    public void addEntrancePanel(EntrancePoint point){
        ParkingLot.addEntrancePanel( point);
    }
    public void removeEntrancePanel(EntrancePoint point){
        ParkingLot.removeEntrancePanel( point);
    }
    public void addExitPanel(ExitPoint point){
        ParkingLot.addExitPanel(point);
    }
    public void removeExitPanel( ExitPoint point){
        ParkingLot.removeExitPanel( point);
    }


}
