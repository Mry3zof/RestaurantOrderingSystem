package com.restaurant.discount;

import com.restaurant.menu.MenuItem;
import com.restaurant.order.OrderBuilder;

public class PizzaDiscount implements DiscountStrategy {

    private final OrderBuilder order;

    public PizzaDiscount(OrderBuilder order) {
        this.order = order;
    }

    @Override
    public double applyDiscount(double subtotal) {
        for (MenuItem item : order.getItems()) {
            String name = item.getDescription().toLowerCase();
            if (name.contains("pizza")) {
                System.out.println("Pizza Discount Applied: 5% off!");
                return subtotal * 0.95;
            }
        }

        return subtotal; // no discount applied
    }
}
