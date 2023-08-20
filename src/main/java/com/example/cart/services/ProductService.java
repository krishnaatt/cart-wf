package com.example.cart.services;

import org.springframework.stereotype.Service;

import com.example.cart.dao.ProductItems;
import com.example.cart.dao.ProductItems.Product;

@Service
public class ProductService {
        ProductItems itemPrices = new ProductItems();

        public ProductService() {
            
        }

        public Product getProduct(int productId) {
            return itemPrices.getItem(productId);
        }
}
