package com.restaurant.billing;

import com.restaurant.discount.DiscountStrategy;
import com.restaurant.payment.PaymentStrategy;

public class BillingSystem {
    private PaymentStrategy paymentStrategy;
    private DiscountStrategy discountStrategy;

    public BillingSystem(PaymentStrategy payment, DiscountStrategy discount) {
        this.paymentStrategy = payment;
        this.discountStrategy = discount;
    }

    public void checkout(double amount) {
        double discounted = discountStrategy.applyDiscount(amount);
        paymentStrategy.pay(discounted);
    }
}
