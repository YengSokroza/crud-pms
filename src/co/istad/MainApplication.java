package co.istad;

import co.istad.controller.MenuController;
import co.istad.controller.ProductController;
import co.istad.exception.InvalidInputException;
import co.istad.util.IO;
import co.istad.util.Singleton;

import java.util.Scanner;

public class MainApplication {
/*    when use final on instance of class,
    it is mean that instance became the required of that class,
    so the class can only be use or run when the class use that instance,
    it also called required dependency
 */
    private final Scanner scanner;
    private final MenuController menuController;
    private final ProductController productController;
    private final IO io;
    public MainApplication(){
        scanner = Singleton.scanner();
        menuController = Singleton.menuController();
        productController = Singleton.productController();
        io = Singleton.io();
    }

    private void run() throws InvalidInputException {
        boolean shouldContinue = true;
        while (shouldContinue){
            menuController.index();
            System.out.print("Enter Option: ");
            int opt = Integer.parseInt(scanner.nextLine());
            switch (opt){
                case 1 -> productController.index();
                case 2 -> {
                    System.out.println("===Add New Product===");
                    String name = io.getValidProductName(scanner);
                    Integer qty = io.getValidProductQuantity(scanner);
                    Double price = io.getValidProductPrice(scanner);
                    productController.insert(name,qty,price);
                }
                case 3 -> {
                    System.out.println("===Select Product By ID===");
                    Long id = io.getValidProductId(scanner);
                    productController.selectById(id);

                }
                case 4 -> {
                    System.out.println("===Select Product By Name===");
                    String name = io.getValidProductName(scanner);
                    productController.selectByName(name);
                }
                case 5 -> {
                    System.out.println("===Update Product By ID===");
                    Long id = io.getValidProductId(scanner);
                    String name = io.getValidProductName(scanner);
                    Integer qty = io.getValidProductQuantity(scanner);
                    Double price = io.getValidProductPrice(scanner);
                    productController.updateById(id,name,qty,price);
                }
                case 6 -> {
                    System.out.println("===Delete Product By ID===");
                    Long id = io.getValidProductId(scanner);
                    productController.deleteById(id);
                }
                case 0 -> {
                    System.out.println("Exiting...");
                    shouldContinue = false;
                }
                default -> throw new IllegalStateException();
            }
        }
    }

    public static void main(String[] args) throws InvalidInputException {
        new MainApplication().run();
    }
}
