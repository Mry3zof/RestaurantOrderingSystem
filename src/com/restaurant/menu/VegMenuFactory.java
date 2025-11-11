package com.restaurant.menu;

public class VegMenuFactory implements MenuFactory {
    @Override
    public MenuItem createMainDish() {
        return new Pizza();
    }

    @Override
    public MenuItem createDrink() {
        return new MenuItem() {
            {
                description = "Fresh Juice";
            }

            @Override
            public double getCost() {
                return 30.0;
            }
        };
    }
}
