package com.restaurant.ui;

import com.restaurant.addons.*;
import com.restaurant.billing.BillingSystem;
import com.restaurant.discount.*;
import com.restaurant.menu.*;
import com.restaurant.menu.kids.*;
import com.restaurant.menu.veg.*;
import com.restaurant.menu.nonveg.*;
import com.restaurant.notification.*;
import com.restaurant.order.*;
import com.restaurant.payment.*;

public class WorkflowController {
    public void start() {
        System.out.println("🍽️ Welcome to the Restaurant Ordering System!");
        OrderBuilder order = new OrderBuilder();

        boolean ordering = true;

        while (ordering) {
            System.out.println("\nSelect Menu Category:");
            System.out.println("1. Kids Menu");
            System.out.println("2. Veg Menu");
            System.out.println("3. Non-Veg Menu");
            System.out.println("0. Finish Order");
            int category = InputHelper.readInt("Enter choice: ");

            if (category == 0) {
                ordering = false;
                break;
            }

            System.out.println("\nSelect an item:");
            switch (category) {
                case 1 -> {
                    System.out.println("1. Kids Burger (50)");
                    System.out.println("2. Kids Pasta (55)");
                }
                case 2 -> {
                    System.out.println("1. Veg Pizza (90)");
                    System.out.println("2. Veg Salad (60)");
                }
                case 3 -> {
                    System.out.println("1. Chicken Burger (110)");
                    System.out.println("2. Beef Steak (130)");
                    System.out.println("3. Pizza (100)");
                    System.out.println("4. Pasta (90)");
                }
            }
            System.out.println("0. Go back");

            int choice = InputHelper.readInt("Enter choice: ");
            if (choice == 0) continue;

            MenuItem item = null;

            switch (category) {
                case 1 -> {
                    if (choice == 1) item = new KidsBurger();
                    else if (choice == 2) item = new KidsPasta();
                }
                case 2 -> {
                    if (choice == 1) item = new VegPizza();
                    else if (choice == 2) item = new VegSalad();
                }
                case 3 -> {
                    if (choice == 1) item = new ChickenBurger();
                    else if (choice == 2) item = new BeefSteak();
                    else if (choice == 3) item = new Pizza();
                    else if (choice == 4) item = new Pasta();
                }
            }

//            // Add-ons
//            if (item != null) {
//                System.out.println("Add-ons: 1. Cheese (+20), 2. Sauce (+10), 3. None");
//                int addOnChoice = InputHelper.readInt("Enter: ");
//                switch (addOnChoice) {
//                    case 1 -> item = new ExtraCheese(item);
//                    case 2 -> item = new ExtraSauce(item);
//                }
//                order.addItem(item);
//                System.out.println(item.getDescription() + " added!");
//            }

            if (item != null) {
                System.out.println("Add-ons: 1. Cheese (+20), 2. Sauce (+10), 3. None");
                int addOnChoice = InputHelper.readInt("Enter: ");
                switch (addOnChoice) {
                    case 1 -> item = new ExtraCheese(item);
                    case 2 -> item = new ExtraSauce(item);
                }
                order.addItem(item);
                System.out.println(item.getDescription() + " added!");

                // 🧾 Show Live Cart Summary
                System.out.println("\nCurrent Order Summary:");
                order.getItems().forEach(i -> System.out.println(" - " + i.getDescription() + " : " + i.getCost() + " LE"));
                System.out.println("Subtotal so far: " + order.calculateSubtotal() + " LE");
            }
        }

        double subtotal = order.calculateSubtotal();
        System.out.println("\nSubtotal: " + subtotal + " LE");

        // Choose Discount
        System.out.println("\nSelect Discount Type:");
        System.out.println("1. No Discount");
        System.out.println("2. Holiday Discount (15%)");

        int discountChoice = InputHelper.readInt("Enter choice: ");
        DiscountStrategy discount = switch (discountChoice) {
            case 2 -> new HolidayDiscount();
            default -> new NoDiscount();
        };

        // Choose Order Type (Now using ENUM)
        System.out.println("\nOrder Type:");
        System.out.println("1. Dine-In");
        System.out.println("2. Takeaway");
        System.out.println("3. Delivery");

        int orderTypeChoice = InputHelper.readInt("Enter choice: ");
        OrderType orderType = switch (orderTypeChoice) {
            case 1 -> OrderType.DINE_IN;
            case 2 -> OrderType.TAKEAWAY;
            case 3 -> OrderType.DELIVERY;
            default -> OrderType.DINE_IN;
        };

        // Set up Notification System
        OrderNotifier notifier = new OrderNotifier();
        Kitchen kitchen = new Kitchen(); // always notified
        notifier.attach(kitchen);

        Waiter staff = new Waiter("Youssef");
        DeliveryDriver driver = new DeliveryDriver("Ahmed");

        switch (orderType) {
            case DINE_IN -> {
                notifier.attach(staff);
                notifier.notifyObservers("New Dine-In order received!");
            }
            case TAKEAWAY -> notifier.notifyObservers("New Takeaway order ready!");
            case DELIVERY -> {
                notifier.attach(driver);
                notifier.notifyObservers("New Delivery order ready for pickup!");
            }
        }

        // Choose Payment Method
        System.out.println("\nSelect Payment Method:");
        System.out.println("1. Cash");
        System.out.println("2. Card");
        System.out.println("3. Mobile Wallet");

        int payChoice = InputHelper.readInt("Enter choice: ");
        PaymentStrategy payment = switch (payChoice) {
            case 2 -> new CardPayment();
            case 3 -> new EWalletPayment();
            default -> new CashPayment();
        };

        // Checkout
        BillingSystem billing = new BillingSystem(payment, discount);
        billing.checkout(subtotal);

        System.out.println("\nThank you for ordering!");
    }
}
