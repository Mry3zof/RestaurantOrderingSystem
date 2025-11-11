package com.restaurant.order;

import com.restaurant.menu.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class OrderBuilder {
    private List<MenuItem> items = new ArrayList<>();

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public double calculateSubtotal() {
        return items.stream().mapToDouble(MenuItem::getCost).sum();
    }

    public List<MenuItem> getItems() {
        return items;
    }
}
