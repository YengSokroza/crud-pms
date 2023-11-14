package co.istad.database;

import co.istad.model.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {
    private List<Product> products;

    public ProductDatabase(){
        products = new ArrayList<>();
        products.add(new Product(1L,"cola",100,2500.0, LocalDate.now()));
        products.add(new Product(2L,"milk",100,2500.0, LocalDate.now()));
        products.add(new Product(3L,"bread",100,2500.0, LocalDate.now()));
        products.add(new Product(4L,"water",100,2500.0, LocalDate.now()));
    }

    public List<Product> getProducts() {
        return products;
    }
}
