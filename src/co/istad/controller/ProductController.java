package co.istad.controller;

import co.istad.database.ProductDatabase;
import co.istad.model.Product;
import co.istad.service.ProductService;
import co.istad.service.ProductServiceImpl;
import co.istad.view.ProductView;

import java.time.LocalDate;
import java.util.List;

public class ProductController {
    private final ProductService productService;
    private final ProductDatabase productDb;


    public ProductController(){
        productService = new ProductServiceImpl();
        productDb = new ProductDatabase();
    }
    public void index(){
        List<Product> products = productService.select();
        ProductView.printProductList(products);
    }

    public void selectById(Long id){
        ProductView.printOneProduct(productService.selectById(id));
    }

    public void selectByName(String name){
        ProductView.printProductList(productService.selectByName(name));
    }

    public void deleteById(Long id){
       ProductView.printOneProduct(productService.DeleteById(id));
    }

    public void updateById(Long id, String name, Integer qty, Double price){
        Product product = productService.selectById(id);
        product.setName(name);
        product.setQty(qty);
        product.setPrice(price);
        Product updated = productService.UpdateById(product);
        ProductView.printOneProduct(updated);
    }

    public void insert(String name, Integer qty, Double price){
        Long id = (long) (productDb.getProducts().size() + 1);
        Product product = new Product(id,name,qty,price,LocalDate.now());
        ProductView.printOneProduct(productService.insert(product));
    }


}
