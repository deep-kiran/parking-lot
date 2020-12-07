package com.company.models.actors;

import com.company.models.Constants;
import com.company.models.Gate;
import com.company.models.ParkingTicket;
import com.company.models.payment.Payment;
import com.company.models.vehicles.Vehicle;
import com.company.utils.DateUtils;
import com.company.enums.ParkingTicketStatus;

import java.util.Date;

public class ParkingAttendant extends Person{
    private Gate gate;
    public void processTicket(Vehicle vehicle){
        ParkingTicket ticket = vehicle.getTicket();
        Date date =new Date();
        switch (ticket.getStatus()){
            case ACTIVE:
                long amount  = DateUtils.timeDifferenceInHours(date, ticket.getCreatedAt())* Constants.getRate();
                Payment.showPayment(amount);
                ticket.setStatus(ParkingTicketStatus.PAID);
            case LOST:
                amount  = DateUtils.timeDifferenceInHours(date, ticket.getCreatedAt())* Constants.getFineRate();
                Payment.showPayment(amount);
        }
        return;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public void assignTicket(Vehicle vehicle){
        ParkingTicket ticket =new ParkingTicket();
        vehicle.setTicket(ticket);
    }
    public void processPayment(){

    }

    public Gate getGate() {
       return gate;
    }
}
