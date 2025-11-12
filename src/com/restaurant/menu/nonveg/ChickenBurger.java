package com.restaurant.menu.nonveg;

import com.restaurant.menu.MenuItem;

public class ChickenBurger extends MenuItem {
    public ChickenBurger() {
        description = "Grilled Chicken Burger";
    }

    @Override
    public double getCost() {
        return 110.0;
    }
}
