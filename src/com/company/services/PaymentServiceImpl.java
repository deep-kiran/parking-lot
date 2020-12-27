package com.company.services;

import com.company.enums.PaymentType;
import com.company.models.ParkingTicket;
import com.company.models.actors.ParkingLotSystem;
import com.company.models.payment.Payment;
import com.company.models.vehicles.Vehicle;

import java.util.HashMap;
import java.util.UUID;

public class PaymentServiceImpl implements PaymentService{
    HashMap<Long, Payment> paymentHashMap =new HashMap<>();
    @Override
    public void processParkingTicket(ParkingTicket ticket, Vehicle vehicle) {
        String amount = ticket.process();
        ParkingLotSystem.print("Amount to be paid is "+amount);

    }

    @Override
    public void collectPayment(Vehicle vehicle, int amount, PaymentType paymentType) {
        Payment payment = Payment.Factory.getPayment(paymentType,amount);
        paymentHashMap.put(payment.getId(),payment);
        vehicle.getTicket().successFullPayment();

    }
}
