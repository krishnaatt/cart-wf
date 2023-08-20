package com.example.cart;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cart.dao.UserCart;
import com.example.cart.dao.UserCheckout;
import com.example.cart.models.CheckoutItem;
import com.example.cart.services.CartService;
import com.example.cart.services.CheckoutService;


@RestController
public class CheckoutController {
    CartService cartService;
    CheckoutService checkoutService;
    public CheckoutController(CartService cartService, CheckoutService checkoutService) {
        this.cartService = cartService;
        this.checkoutService = checkoutService;
    }
    
    @PostMapping("/create/checkout")
    public UserCheckout createCheckout(@RequestBody int userId) {
        UserCart userCart = cartService.getUserCart(userId);
        List<CheckoutItem> checkoutItems = checkoutService.createCheckoutItems(userCart.getItems());
        UserCheckout userCheckout = checkoutService.createCheckoutRecord(userId, checkoutItems, "7, Lok Kalyan Marg");
       /*
        1. check if all the products exist in the inventory
        2. check the latest prices of all the items
        3. get the latest offers and auto apply them
        4. create an entry in the checkout table and snapshot the prices to the latest ones
           a. status tracking of checkout in a state machine
        5. make the UserCart invisible
        6. move to the payment page and make payment gateway call
           a.call productService to lock/reduce the inventory count for the products
        7. if payment ==
           a. SUCCESS: 
              i.change status of the checkout flow
              ii.create record in the order history {userId, checkoutId, {[productId, price], [productId, price]}}
              iii.delete UserCart record, call emptyCart(int userId)
              iv.call productService to lock the inventory
           b. FAILED:
              i. make the entry in the checkout visible again
       */

       //TODO: to close points 5-7
       return userCheckout;
    }
}
