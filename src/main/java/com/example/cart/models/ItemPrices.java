package com.example.cart.models;

import java.util.ArrayList;
import java.util.List;

public class ItemPrices {
    List<Item> items;

    public ItemPrices() {
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    };

    public void addItem(Item item) {
        items.add(item);
    }
    public record Item(int productId, double price){}
}
