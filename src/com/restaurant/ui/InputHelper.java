package com.restaurant.ui;

import java.util.Scanner;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);

    public static int readInt(String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static String readString(String message) {
        System.out.print(message);
        return scanner.next();
    }
}
