package com.restaurant.menu.veg;

import com.restaurant.menu.MenuItem;

public class VegSalad extends MenuItem {
    public VegSalad() {
        description = "Fresh Green Salad";
    }

    @Override
    public double getCost() {
        return 60.0;
    }
}
