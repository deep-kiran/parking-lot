package com.company.api;

import com.company.enums.ParkingTicketStatus;
import com.company.enums.PaymentType;
import com.company.exceptions.AlreadyPaidException;
import com.company.exceptions.NoTicketAssignedException;
import com.company.exceptions.ParkingFullException;
import com.company.models.Address;
import com.company.models.ParkingLot;
import com.company.models.ParkingTicket;
import com.company.models.vehicles.Vehicle;
import com.company.services.ParkingService;
import com.company.services.PaymentService;

public class ParkingAttendantController {
    PaymentService paymentService;
    ParkingService parkingService;

    private ParkingAttendantController(){}
    ParkingAttendantController(PaymentService paymentService, ParkingService parkingService){
        this.paymentService =paymentService;
        this.parkingService =parkingService;
    }
    void processTicket(ParkingTicket ticket, Vehicle vehicle){
        if(vehicle.getTicket()==null){
            throw new NoTicketAssignedException("Vehicle hasn't been assigned parkingTicket");
        }
        if(ticket.getStatus()== ParkingTicketStatus.PAID){
            throw new AlreadyPaidException("The ticket has already been paid");
        }
        paymentService.processParkingTicket(ticket,vehicle);
    }

    public void assignTicket(ParkingLot parkingLot, Vehicle vehicle){
        if(!parkingService.canFit(parkingLot, vehicle)){
            throw new ParkingFullException();
        }
        parkingService.assignTicket(vehicle);
    }

    void collectPayment(Vehicle vehicle,int amount, PaymentType paymentType){
        paymentService.collectPayment(vehicle,amount, paymentType);
    }
}
