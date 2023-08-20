package com.example.cart.services;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.cart.dao.UserCheckout;
import com.example.cart.dao.ProductItems.Product;
import com.example.cart.dao.CartItem;
import com.example.cart.idfs.CheckoutStatus;
import com.example.cart.models.CheckoutItem;
import com.example.cart.models.PricesObject;

@Service
public class CheckoutService {
    ProductService productService = new ProductService();
    List<UserCheckout> checkoutTable = new ArrayList<>();

    public CheckoutService() {

    }

    public PricesObject sumOfPrices(double[] prices) {
        double sum = 0;
        for (double price : prices)
            sum += price;
        return new PricesObject(sum, "Calculated the sum!");
    }

    public List<CheckoutItem> createCheckoutItems(List<CartItem> cartItems) {
        List<CheckoutItem> response = new ArrayList<>();
        for(CartItem cartItem: cartItems) {
          Product product = productService.getProduct(cartItem.getProductId());
          //apply discount on the price
          double latestPrice = product.price() - product.price()*product.offerDiscountPercent()/100;
          //check quantity and take max number of quanity possible
          if(product.quantity()>=cartItem.getCount()) {
            response.add(new CheckoutItem(product.productId(), latestPrice, product.offerDiscountPercent(), cartItem.getCount()));
          } else {
            response.add(new CheckoutItem(product.productId(), latestPrice, product.offerDiscountPercent(), cartItem.getCount()));
          }
        }
        return response;
    }

    public UserCheckout createCheckoutRecord(int userId, List<CheckoutItem> checkoutItems, String addressId) {
       UserCheckout newUserCheckout = new UserCheckout(UUID.randomUUID(), userId, checkoutItems, Timestamp.valueOf(LocalDateTime.now()), addressId, CheckoutStatus.INITIATED);
       checkoutTable.add(newUserCheckout);
       return newUserCheckout;
    }
}
