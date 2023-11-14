package co.istad.util;

import co.istad.controller.MenuController;
import co.istad.controller.ProductController;
import co.istad.service.ProductServiceImpl;

import java.util.Scanner;

public class Singleton {
    //1. create static reference type
    private static Scanner scanner;
    private static ProductController productController;
    private static MenuController menuController;
    private static ProductServiceImpl productServiceImpl;
    private static IO io;

    //2. Create get instance of scanner
    public static Scanner scanner(){
        if(scanner == null){
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    public static ProductController productController(){
        if(productController == null){
            productController = new ProductController();
        }
        return productController;
    }

    public static ProductServiceImpl productServiceImpl(){
        if(productServiceImpl == null){ //if the reference equal to null, it will create one. if not equal to null, it will just use the old one
            productServiceImpl = new ProductServiceImpl();
        }
        return productServiceImpl;
    }

    public static MenuController menuController(){
        if(menuController == null){ //if the reference equal to null, it will create one. if not equal to null, it will just use the old one
            menuController = new MenuController();
        }
        return menuController;
    }

    public static IO io(){
        if(io == null){ //if the reference equal to null, it will create one. if not equal to null, it will just use the old one
            io = new IO();
        }
        return io;
    }


}
