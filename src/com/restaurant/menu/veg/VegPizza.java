package com.restaurant.menu.veg;

import com.restaurant.menu.MenuItem;

public class VegPizza extends MenuItem {
    public VegPizza() {
        description = "Vegetarian Pizza";
    }

    @Override
    public double getCost() {
        return 90.0;
    }
}
