package com.company.models.payment;

import com.company.enums.PaymentType;

public class CashPayment extends Payment{
    public CashPayment(double amount){
        super(amount, PaymentType.CASH);
    }
}
