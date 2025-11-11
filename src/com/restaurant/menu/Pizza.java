package com.restaurant.menu;

public class Pizza extends MenuItem {
    public Pizza() {
        description = "Classic Pizza";
    }

    @Override
    public double getCost() {
        return 100.0;
    }
}
