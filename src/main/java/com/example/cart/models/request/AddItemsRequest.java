package com.example.cart.models.request;

import java.util.List;

import com.example.cart.dao.CartItem;

public class AddItemsRequest {
    int userId;
    List<CartItem> items;

    public AddItemsRequest() {

    }

    public AddItemsRequest(int userId, List<CartItem> items) {
        this.userId = userId;
        this.items = items;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

}
