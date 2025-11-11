package com.restaurant.menu;

public abstract class MenuItem {
    protected String description = "Unknown Item";

    public String getDescription() {
        return description;
    }

    public abstract double getCost();
}
