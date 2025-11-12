package com.restaurant.menu.nonveg;

import com.restaurant.menu.MenuItem;

public class Pasta extends MenuItem {
    public Pasta() {
        description = "Creamy Pasta";
    }

    @Override
    public double getCost() {
        return 90.0;
    }
}
