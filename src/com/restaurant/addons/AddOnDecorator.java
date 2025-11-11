package com.restaurant.addons;

import com.restaurant.menu.MenuItem;

public abstract class AddOnDecorator extends MenuItem {
    protected MenuItem item;
    public abstract String getDescription();
}
