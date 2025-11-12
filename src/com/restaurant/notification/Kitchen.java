package com.restaurant.notification;

public class Kitchen implements Observer {
    @Override
    public void update(String message) {
        System.out.println("Kitchen received: " + message);
    }
}
