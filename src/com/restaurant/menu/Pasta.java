package com.restaurant.menu;

public class Pasta extends MenuItem {
    public Pasta() {
        description = "Creamy Pasta";
    }

    @Override
    public double getCost() {
        return 90.0;
    }
}
