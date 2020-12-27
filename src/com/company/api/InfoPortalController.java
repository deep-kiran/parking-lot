package com.company.api;

import com.company.enums.ParkingTicketStatus;
import com.company.enums.PaymentType;
import com.company.exceptions.AlreadyPaidException;
import com.company.exceptions.NoTicketAssignedException;
import com.company.models.ParkingTicket;
import com.company.models.vehicles.Vehicle;
import com.company.services.ParkingService;
import com.company.services.PaymentService;

public class InfoPortalController {
    ParkingService parkingService;
    PaymentService paymentService;
    InfoPortalController(ParkingService parkingService, PaymentService paymentService){
        this.parkingService =parkingService;
        this.paymentService =paymentService;
    }

    void processPayment(Vehicle vehicle){
        if(vehicle.getTicket()==null){
            throw new NoTicketAssignedException("Vehicle hasn't been assigned parkingTicket");
        }
        if(vehicle.getTicket().getStatus()== ParkingTicketStatus.PAID){
            throw new AlreadyPaidException("The ticket has already been paid");
        }
        ParkingTicket parkingTicket =vehicle.getTicket();
        parkingTicket.process();
    }

    void collectPayment(Vehicle vehicle, int amount, PaymentType paymentType){
        paymentService.collectPayment(vehicle,amount,paymentType);
    }
}
