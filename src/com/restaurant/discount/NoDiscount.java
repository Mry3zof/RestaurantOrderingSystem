package com.restaurant.discount;

public class NoDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double total) {
        return total; // no change
    }
}
