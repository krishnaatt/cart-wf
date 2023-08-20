package com.example.cart.models.request;

public class GetCartValueRequest {
    int userId;
    
    public GetCartValueRequest() {
        
    }

    public GetCartValueRequest(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
