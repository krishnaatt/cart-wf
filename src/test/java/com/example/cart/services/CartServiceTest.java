package com.example.cart.services;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.example.cart.dao.CartItem;

@TestInstance(Lifecycle.PER_CLASS)
public class CartServiceTest {
    CartService cartService;

    @BeforeAll
    public void setup() {
       cartService = new CartService();
       List<CartItem> items = Arrays.asList({ new CartItem(1, 3), new CartItem(2, 4) });
    }

    @Test
    public void testAddItem() {

    }
}
