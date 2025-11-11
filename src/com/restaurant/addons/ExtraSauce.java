package com.restaurant.addons;

import com.restaurant.menu.MenuItem;

public class ExtraSauce extends AddOnDecorator {
    public ExtraSauce(MenuItem item) {
        this.item = item;
    }

    @Override
    public String getDescription() {
        return item.getDescription() + ", Extra Sauce";
    }

    @Override
    public double getCost() {
        return item.getCost() + 10.0;
    }
}