package com.example.cart.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import com.example.cart.idfs.CheckoutStatus;
import com.example.cart.models.CheckoutItem;

public class UserCheckout {
    UUID id;
    int userId;
    List<CheckoutItem> items;
    Timestamp timestamp;
    String addressId;
    CheckoutStatus checkoutStatus;

    public UserCheckout(UUID id, int userId, List<CheckoutItem> items, Timestamp timestamp, String addressId,
            CheckoutStatus checkoutStatus) {
        this.id = id;
        this.userId = userId;
        this.items = items;
        this.timestamp = timestamp;
        this.addressId = addressId;
        this.checkoutStatus = checkoutStatus;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public List<CheckoutItem> getItems() {
        return items;
    }
    public void setItems(List<CheckoutItem> items) {
        this.items = items;
    }
    public Timestamp getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
    public String getAddressId() {
        return addressId;
    }
    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }
    public CheckoutStatus getCheckoutStatus() {
        return checkoutStatus;
    }
    public void setCheckoutStatus(CheckoutStatus checkoutStatus) {
        this.checkoutStatus = checkoutStatus;
    }
}
