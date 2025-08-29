package org.example.onlineshop.model;

import java.time.LocalDateTime;

public class Order {

    private int id;
    private int userId;
    private int productId;
    private int quantity;
    private LocalDateTime orderDate;

    public Order(int userId, int productId, int quantity, LocalDateTime orderDate) {
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.orderDate = orderDate;
    }

    public Order(int userId, int productId, int quantity) {
        this.userId = userId;
        this.productId = productId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }

}
