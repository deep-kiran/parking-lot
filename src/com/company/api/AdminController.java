package com.company.api;

import com.company.models.*;
import com.company.models.actors.Admin;
import com.company.models.actors.ParkingAttendant;
import com.company.services.AdminService;

public class AdminController {

    AdminService adminService;
    private AdminController(){}

    public AdminController(AdminService service){
        this.adminService = service;
    }
    public ParkingLot createParkingLot(Address address){
        ParkingLot parkingLot = adminService.createParkingLot(address);
        return parkingLot;
    }

    public ParkingAttendant addParkingAttendant(String name, String email){
        ParkingAttendant parkingAttendant = adminService.createParkingAttendant(name,email);
        return parkingAttendant;
    }

    public  void setHourlyRate(int r){
        Constants.setParkingRate(r);
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

    public void addParkingFloor(ParkingLot parkingLot, ParkingFloor floor){
        adminService.addParkingFloor(parkingLot, floor);
    }
    public void addParkingAttendant(ParkingLot parkingLot, Gate gate, ParkingAttendant attendant){
        adminService.addParkingAttendant(parkingLot,gate,attendant);
    }
    public void addEntrancePanel(ParkingLot parkingLot,EntrancePoint point){
        adminService.addEntrancePanel( parkingLot, point);
    }
    public void removeEntrancePanel(ParkingLot parkingLot, EntrancePoint point){
        adminService.removeEntrancePanel(parkingLot, point);
    }
    public void addExitPanel(ParkingLot parkingLot, ExitPoint point){
        adminService.addExitPanel(parkingLot,point);
    }
    public void removeExitPanel( ParkingLot parkingLot, ExitPoint point){
        adminService.removeExitPanel(parkingLot, point);
    }

}
