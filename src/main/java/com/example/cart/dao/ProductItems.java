package com.example.cart.dao;

import java.util.ArrayList;
import java.util.List;

public class ProductItems {
    List<Product> products;

    public ProductItems() {
        products = new ArrayList<>();
        products.add(new Product(1, 10, 500, 5));
        products.add(new Product(2, 10, 600, 10));
        products.add(new Product(3, 10, 700, 15));
        products.add(new Product(4, 10, 1000, 25));
        products.add(new Product(5, 20, 100, 2));

    }

    public record Product(int productId,
            int quantity,
            double price,
            double offerDiscountPercent) {
    }

    public Product getItem(int productId) {
        for (Product product : products) {
            if (productId == product.productId())
                return product;
        }
        return null;
    }

}
