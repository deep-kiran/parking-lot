package com.company.models.payment;

import com.company.enums.PaymentType;

import java.util.Date;

public abstract class Payment {
    double amount;
    Date createdTime;
    PaymentType type;
    public Payment(double amount, PaymentType type,String nameOnCard){
        this.amount =amount;
        this.createdTime =new Date();
        this.type =type;
    }
    public Payment(double amount, PaymentType type){
        this.amount =amount;
        this.createdTime =new Date();
        this.type =type;
    }

    public static void showPayment(long amount) {
        System.out.println("The amount to be given is "+ amount);
    }
}
