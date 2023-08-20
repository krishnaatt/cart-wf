package com.example.cart.dao;

public class CartItem {
        int productId;
        int count;

        public CartItem() {

        }

        public CartItem(int productId, int count) {
            this.productId = productId;
            this.count = count;
        }

        public int getProductId() {
            return productId;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int newCount) {
            this.count = newCount;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }
}

