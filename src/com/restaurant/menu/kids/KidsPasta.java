package com.restaurant.menu.kids;

import com.restaurant.menu.MenuItem;

public class KidsPasta extends MenuItem {
    public KidsPasta() {
        description = "Kids Creamy Pasta";
    }

    @Override
    public double getCost() {
        return 55.0;
    }
}
