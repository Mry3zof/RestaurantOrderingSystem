package com.restaurant.discount;

import com.restaurant.menu.MenuItem;
import com.restaurant.order.OrderBuilder;

public class ComboMealDiscount implements DiscountStrategy {
    private final OrderBuilder order;

    public ComboMealDiscount(OrderBuilder order) {
        this.order = order;
    }

    @Override
    public double applyDiscount(double subtotal) {
        boolean hasKids = false;
        boolean hasAdult = false;

        for (MenuItem item : order.getItems()) {
            String name = item.getDescription().toLowerCase();

            if (name.contains("kids")) {
                hasKids = true;
            } else {
                // ANY non-kids item = adult meal (veg or non-veg)
                hasAdult = true;
            }
        }

        if (hasKids && hasAdult) {
            System.out.println("Combo Meal Discount Applied: 15% off!");
            return subtotal * 0.85; // 15% discount
        }

        return subtotal; // no discount
    }
}
