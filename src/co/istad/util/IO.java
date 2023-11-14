package co.istad.util;

import co.istad.exception.InvalidInputException;

import java.util.Scanner;

public class IO {
    private static boolean isValidString(String input) {
        return input.matches("^[a-zA-Z]+$");
    }

    public Long getValidProductId(Scanner scanner) throws InvalidInputException {
        System.out.print("Enter Product ID: ");
        Long id = Long.parseLong(scanner.nextLine());

        if (id < 0) {
            throw new InvalidInputException("Negative numbers not allowed for ID.");
        }

        return id;
    }
    public String getValidProductName(Scanner scanner) throws InvalidInputException {
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();

        if (!isValidString(name)) {
            throw new InvalidInputException("Invalid input. Please enter a valid name.");
        }

        return name;
    }

    public int getValidProductQuantity(Scanner scanner) throws InvalidInputException {
        System.out.print("Enter Product Quantities: ");
        int qty = Integer.parseInt(scanner.nextLine());

        if (qty < 0) {
            throw new InvalidInputException("Negative numbers not allowed for quantities.");
        }

        return qty;
    }

    public double getValidProductPrice(Scanner scanner) throws InvalidInputException {
        System.out.print("Enter Product Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        if (price < 0) {
            throw new InvalidInputException("Negative numbers not allowed for price.");
        }

        return price;
    }
}
