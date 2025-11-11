package com.restaurant.payment;

public class EWalletPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Mobile Wallet.");
    }
}
