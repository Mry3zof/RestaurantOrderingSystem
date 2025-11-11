package com.restaurant.ui;

import com.restaurant.addons.ExtraCheese;
import com.restaurant.addons.ExtraSauce;
import com.restaurant.billing.BillingSystem;
import com.restaurant.discount.PizzaDiscount;
import com.restaurant.discount.DiscountStrategy;
import com.restaurant.menu.*;
import com.restaurant.order.OrderBuilder;
import com.restaurant.payment.*;

public class WorkflowController {

    public void start() {
        System.out.println("🍽️ Welcome to the Restaurant Ordering System!");
        OrderBuilder order = new OrderBuilder();

        boolean ordering = true;
        while (ordering) {
            System.out.println("\nSelect a menu item:");
            System.out.println("1. Pizza (100 LE)");
            System.out.println("2. Burger (80 LE)");
            System.out.println("3. Pasta (90 LE)");
            System.out.println("4. Finish Order");

            int choice = InputHelper.readInt("Enter your choice: ");

            MenuItem item = null;
            switch (choice) {
                case 1 -> item = new Pizza();
                case 2 -> item = new Burger();
                case 3 -> item = new Pasta();
                case 4 -> ordering = false;
                default -> System.out.println("Invalid choice.");
            }

            if (item != null) {
                // Add-ons
                System.out.println("\nWould you like to add any add-ons?");
                System.out.println("1. Extra Cheese (+20)");
                System.out.println("2. Extra Sauce (+10)");
                System.out.println("3. None");

                int addOnChoice = InputHelper.readInt("Enter choice: ");
                switch (addOnChoice) {
                    case 1 -> item = new ExtraCheese(item);
                    case 2 -> item = new ExtraSauce(item);
                    case 3 -> { /* no add-on */ }
                    default -> System.out.println("Invalid add-on option.");
                }

                order.addItem(item);
                System.out.println(item.getDescription() + " added to order.");
            }
        }

        double subtotal = order.calculateSubtotal();
        System.out.println("\nSubtotal: " + subtotal + " LE");

        // Discount
        DiscountStrategy discount = new PizzaDiscount();
        double discountedTotal = discount.applyDiscount(subtotal);
        System.out.println("Discounted total: " + discountedTotal + " LE");

        // Payment
        System.out.println("\nSelect payment method:");
        System.out.println("1. Cash");
        System.out.println("2. Card");
        System.out.println("3. Wallet");

        int paymentChoice = InputHelper.readInt("Enter choice: ");
        PaymentStrategy payment;
        switch (paymentChoice) {
            case 1 -> payment = new CashPayment();
            case 2 -> payment = new CardPayment();
            case 3 -> payment = new EWalletPayment();
            default -> {
                System.out.println("Invalid choice. Defaulting to Cash.");
                payment = new CashPayment();
            }
        }

        BillingSystem billing = new BillingSystem(payment, discount);
        billing.checkout(subtotal);

        System.out.println("\n🧾 Order complete. Thank you for dining with us!");
    }
}
