package com.restaurant.menu.kids;

import com.restaurant.menu.MenuItem;

public class KidsBurger extends MenuItem {
    public KidsBurger() {
        description = "Kids Mini Burger";
    }

    @Override
    public double getCost() {
        return 50.0;
    }
}
