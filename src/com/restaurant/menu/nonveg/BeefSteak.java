package com.restaurant.menu.nonveg;

import com.restaurant.menu.MenuItem;

public class BeefSteak extends MenuItem {
    public BeefSteak() {
        description = "Beef Steak";
    }

    @Override
    public double getCost() {
        return 130.0;
    }
}
