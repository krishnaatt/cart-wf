package com.example.cart;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cart.dao.UserCart;
import com.example.cart.models.ItemPrices;
import com.example.cart.models.PricesObject;
import com.example.cart.models.TestMessage;
import com.example.cart.models.request.AddItemsRequest;
import com.example.cart.models.request.GetCartValueRequest;
import com.example.cart.models.request.RemoveItemsRequest;
import com.example.cart.services.CartService;
import com.example.cart.services.CheckoutService;
import com.example.cart.services.ProductService;

@RestController
public class CartController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    CheckoutService checkoutService;
    CartService cartService;
    ProductService productService;

    public CartController(CheckoutService checkoutService, CartService cartService, ProductService productService) {
        this.checkoutService = checkoutService;
        this.cartService = cartService;
        this.productService = productService;
    }

    @GetMapping("/test/message")
    public TestMessage testMessage(@RequestParam(value = "name", defaultValue = "world") String name) {
        return new TestMessage(counter.getAndIncrement(), String.format(template, name));
    }

    @PostMapping("/checkout/prices/total")
    public PricesObject testMessage(@RequestParam double[] prices) {
        return checkoutService.sumOfPrices(prices);
    }

    @PostMapping("/cart/add/items")
    public UserCart addItem(@RequestBody AddItemsRequest addItemsRequest) {
        UserCart userCart = cartService.getUserCart(addItemsRequest.getUserId());
        // filter items from product service, based on avaialble quantity
        userCart.getItems().addAll(addItemsRequest.getItems());
        cartService.updateUserCart(userCart);
        return userCart;
    }

    @PostMapping("cart/remove/items")
    public UserCart removeItem(@RequestBody RemoveItemsRequest removeItemsRequest) throws Exception {
        UserCart userCart = cartService.getUserCart(removeItemsRequest.getUserId());
        userCart.removeCartItems(removeItemsRequest.getItems());
        cartService.updateUserCart(userCart);
        return userCart;
    }

    @PostMapping("cart/value")
    public ItemPrices getValue(@RequestBody GetCartValueRequest getCartValueRequest) throws Exception {
        return cartService.getLatestPrices(getCartValueRequest.getUserId());
    }
}
