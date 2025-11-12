package com.restaurant.menu.nonveg;

import com.restaurant.menu.MenuItem;

public class Pizza extends MenuItem {
    public Pizza() {
        description = "Classic Pizza";
    }

    @Override
    public double getCost() {
        return 100.0;
    }
}
