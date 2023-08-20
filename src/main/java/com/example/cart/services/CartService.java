package com.example.cart.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cart.dao.ProductItems.Product;
import com.example.cart.dao.UserCart;
import com.example.cart.dao.CartItem;
import com.example.cart.models.ItemPrices;
import com.example.cart.models.ItemPrices.Item;

@Service
public class CartService {
    ProductService productService = new ProductService();

    List<UserCart> cartTable = new ArrayList<>();

    public CartService() {
    }

    public UserCart getUserCart(int userId) {
        // check if this userId exists in cart table. This is to check if a non-empty
        // cart is present
        for (UserCart cartRecord : cartTable) {
            if (userId == cartRecord.getUserId()) {
                return cartRecord;
            }
        }
        UserCart userCart = new UserCart();
        userCart.setUserId(userId);
        cartTable.add(userCart);
        return userCart;
    }

    public void updateUserCart(UserCart userCart) {
        UserCart removeItem = null;
        boolean itemFound = false;
        for (UserCart cart : cartTable) {
            if (userCart.getUserId() == cart.getUserId()) {
                removeItem = cart;
                itemFound = true;
            }
        }
        if (itemFound) {
            cartTable.remove(removeItem);
        }P
        cartTable.add(userCart);
    }

    public ItemPrices getLatestPrices(int userId) throws Exception {
        UserCart userCart = getUserCart(userId);
        ItemPrices newPrices = new ItemPrices();
        for (CartItem item : userCart.getItems()) {
            Product prod = productService.getProduct(item.getProductId());
            newPrices.addItem(new Item(prod.productId(), prod.price()));
        }
        return newPrices;
    }

    public void lockCart(int userId) {

    }
}
