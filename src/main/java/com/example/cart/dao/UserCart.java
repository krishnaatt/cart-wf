package com.example.cart.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//Make it an entity
public class UserCart {
    //userId to be PK and nonNull
    UUID id;

    //userId to be nonNull and unique
    int userId;
    List<CartItem> items;
    boolean visibiltyStatus;
    Timestamp lastUpdatedTime;
    public UserCart() {
       this.items = new ArrayList<>();
       this.visibiltyStatus = true;
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

    public boolean isVisibiltyStatus() {
        return visibiltyStatus;
    }

    public void setVisibiltyStatus(boolean visibiltyStatus) {
        this.visibiltyStatus = visibiltyStatus;
    }

    public Timestamp getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(Timestamp lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public void removeCartItems(List<CartItem> itemsList) {
        for(CartItem removeItem: itemsList) {
            boolean itemFound = false;
            CartItem modifiedItem = null;
            for(CartItem parseItem: items) {
                if(removeItem.getProductId() == parseItem.getProductId()) {
                   modifiedItem = parseItem;
                   itemFound = true;
                }
            }
            if(itemFound) {
                items.remove(modifiedItem);
                if(modifiedItem.getCount()>removeItem.getCount())  { 
                    modifiedItem.setCount(modifiedItem.getCount()-removeItem.getCount());
                    items.add(modifiedItem);
                }
            }
        }
    } 
    
}
