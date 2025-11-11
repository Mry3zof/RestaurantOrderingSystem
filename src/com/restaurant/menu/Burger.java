package com.restaurant.menu;

public class Burger extends MenuItem {
    public Burger() {
        description = "Classic Burger";
    }

    @Override
    public double getCost() {
        return 80.0;
    }
}
