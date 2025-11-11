package com.restaurant.addons;

import com.restaurant.menu.MenuItem;

public class ExtraCheese extends AddOnDecorator {
    public ExtraCheese(MenuItem item) {
        this.item = item;
    }

    @Override
    public String getDescription() {
        return item.getDescription() + ", Extra Cheese";
    }

    @Override
    public double getCost() {
        return item.getCost() + 20.0;
    }
}
