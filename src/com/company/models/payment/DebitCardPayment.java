package com.company.models.payment;

import com.company.enums.PaymentType;

public class DebitCardPayment extends Payment{

    public DebitCardPayment(double amount, String nameOnCard){
        super(amount, PaymentType.DEBIT_CARD, nameOnCard);
    }
}
