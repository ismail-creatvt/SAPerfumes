package com.saperfumes.models;

import com.saperfumes.product.Product;

import java.util.List;

public class OrderDetailsItem {

    private String id;
    private List<ShoppingCartItem> orderItems;
    private String orderDate;
    private String deliveryDate;
    private String paymentMode;
    private boolean isDelivered;
    private float totalAmount;

    public OrderDetailsItem(String id, List<ShoppingCartItem> orderItems, String orderDate, String deliveryDate, String paymentMode, boolean isDelivered, float totalAmount) {
        this.id = id;
        this.orderItems = orderItems;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.paymentMode = paymentMode;
        this.isDelivered = isDelivered;
        this.totalAmount = totalAmount;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ShoppingCartItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<ShoppingCartItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void setDelivered(boolean delivered) {
        isDelivered = delivered;
    }
}
