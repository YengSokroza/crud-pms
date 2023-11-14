package co.istad.model;

import java.time.LocalDate;
import java.util.Objects;

public class Product {

    private Long id;
    private String name;
    private Integer qty;
    private Double price;
    private LocalDate importedDate;

    Product() {
    }

    public Product(Long id, String name, Integer qty, Double price, LocalDate importedDate) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.importedDate = importedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getImportedDate() {
        return importedDate;
    }

    public void setImportedDate(LocalDate importedDate) {
        this.importedDate = importedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(qty, product.qty) && Objects.equals(price, product.price) && Objects.equals(importedDate, product.importedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, qty, price, importedDate);
    }
}
