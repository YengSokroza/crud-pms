package co.istad.dao;

import co.istad.database.ProductDatabase;
import co.istad.exception.ProductIdNotFoundException;
import co.istad.model.Product;

import java.util.List;
import java.util.Optional;

public class ProductDaoImpl implements ProductDao {

    private final ProductDatabase productDb;

    public ProductDaoImpl (){
        productDb = new ProductDatabase();
    }

    @Override
    public Product insert(Product product) {
        productDb.getProducts().add(product);
        return product;
    }

    @Override
    public List<Product> select() {
        return productDb.getProducts();
    }

    @Override
    public Optional<Product> selectById(Long id) {
        return productDb.getProducts().stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    @Override
    public Product updateById(Product product) {
        return productDb.getProducts().stream()
                .filter(pro -> pro.getId().equals(product.getId()))
                .map(newPro -> product)
                .findFirst()
                .orElseThrow(() -> new ProductIdNotFoundException(
                        String.format("ProductID = %s does not exist in db", product.getId())
                ));
    }

//    public Product updateById(Product product) {
//        List<Product> updatedProducts = productDb.getProducts().stream()
//                .map(pro -> pro.getId().equals(product.getId()) ? product : pro)
//                .collect(Collectors.toList());
//
//        if (updatedProducts.contains(product)) {
//            productDb.setProducts(updatedProducts); // Assuming setProducts is a method to update the products in productDb
//            return product;
//        } else {
//            throw new ProductIdNotFoundException(
//                    String.format("ProductID = %s does not exist in db", product.getId())
//            );
//        }
//    }

    @Override
    public Product deleteById(Long id) {
        Product foundProduct = productDb.getProducts().stream()
                .filter(pro -> pro.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ProductIdNotFoundException(
                        String.format("ProductID = %s does not exist in db", id)
                ));
        productDb.getProducts().remove(foundProduct);
        return foundProduct;
    }

    @Override
    public List<Product> selectByName(String name) {
        return productDb.getProducts().stream()
                .filter(product -> product.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }
}
