package com.restaurant.discount;

public class HolidayDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double total) {
        return total * 0.85; // 15% off
    }
}
