package com.company.models.actors;

import com.company.models.Constants;
import com.company.models.Gate;
import com.company.models.ParkingTicket;
import com.company.models.payment.Payment;
import com.company.models.vehicles.Vehicle;
import com.company.utils.DateUtils;
import com.company.enums.ParkingTicketStatus;

import java.nio.file.FileStore;
import java.util.Date;

public class ParkingAttendant extends Person{
    private Gate gate;



    public void processTicket(Vehicle vehicle){
        ParkingTicket ticket = vehicle.getTicket();
        ticket.process();
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }




    public Gate getGate() {
       return gate;
    }
}
