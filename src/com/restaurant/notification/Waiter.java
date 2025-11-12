package com.restaurant.notification;

public class Waiter implements Observer {
    private String name;

    public Waiter(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Waiter " + name + " notified: " + message);
    }
}
