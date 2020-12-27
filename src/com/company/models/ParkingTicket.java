package com.company.models;

import com.company.enums.ParkingTicketStatus;
import com.company.models.actors.ParkingLotSystem;
import com.company.models.payment.Payment;
import com.company.utils.DateUtils;

import java.util.Date;

public class ParkingTicket extends Auditable{
    private String ticketNumber;
    private ParkingTicketStatus status;

    public ParkingTicket(){
        status =ParkingTicketStatus.ACTIVE;
    }
    public ParkingTicketStatus getStatus() {
        return status;
    }


    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }


    public String process() {
        long amount=0;
        switch (getStatus()){
            case ACTIVE:
                 amount  = DateUtils.timeDifferenceInHours(new Date(), getCreatedAt())* Constants.getRate();
            case LOST:
                amount  = DateUtils.timeDifferenceInHours(new Date(), getCreatedAt())* Constants.getFineRate();
            case PAID:
                amount=0;
        }
        return String.valueOf(amount);
    }

    public void successFullPayment() {
        status =ParkingTicketStatus.PAID;
    }
}
