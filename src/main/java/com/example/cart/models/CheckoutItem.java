package com.example.cart.models;

public record CheckoutItem(int productId, double price, double offerPercentApplied, int quantity) {
}
