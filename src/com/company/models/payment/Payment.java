package com.company.models.payment;

import com.company.enums.PaymentType;
import com.company.models.Auditable;

import java.util.Date;

public abstract class Payment extends Auditable {
    double amount;
    Date createdTime;
    PaymentType type;
    public Payment(double amount, PaymentType type){
        this.amount =amount;
        this.createdTime =new Date();
        this.type =type;
    }


    public static class Factory{

        public static Payment  getPayment(PaymentType paymentType, int amount){
            if(paymentType==PaymentType.CASH){
                return new CashPayment(amount);
            }else
                return new DebitCardPayment(amount);
        }


    }
}
