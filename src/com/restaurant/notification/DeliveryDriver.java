package com.restaurant.notification;

public class DeliveryDriver implements Observer {
    private String name;

    public DeliveryDriver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("🚗 Driver " + name + " notified: " + message);
    }
}
