package com.company.models;

import com.company.enums.ParkingTicketStatus;

public class ParkingTicket extends Auditable{
    private String ticketNumber;
    private ParkingTicketStatus status;


    public ParkingTicketStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingTicketStatus status) {
        this.status = status;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }


}
