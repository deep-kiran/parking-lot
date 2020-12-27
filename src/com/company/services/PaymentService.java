package com.company.services;

import com.company.enums.PaymentType;
import com.company.models.ParkingTicket;
import com.company.models.vehicles.Vehicle;

public interface PaymentService {
    void processParkingTicket(ParkingTicket ticket, Vehicle vehicle);

    void collectPayment(Vehicle vehicle, int amount,PaymentType paymentType);
}
