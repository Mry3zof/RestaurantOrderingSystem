package com.restaurant.discount;

public class PizzaDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.9; // 10% off
    }
}
