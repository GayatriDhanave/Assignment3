package com.entity;

import com.util.OrderStatus;

import java.util.List;

public class Order {



    private long orderId;
//    private Users user;
    private List<Product> product;

    private OrderStatus orderStatus;
    private double totalPrice;

    public Order (long orderId, List<Product> product, OrderStatus orderStatus) {
        this.orderId = orderId;
        this.product = product;
        this.orderStatus = orderStatus;
        this.totalPrice = product.stream().mapToDouble(Product::getTotalPrice).sum();
    }

    public long getOrderId () {
        return orderId;
    }

    public void setOrderId (long orderId) {
        this.orderId = orderId;
    }

    public List<Product> getProduct () {
        return product;
    }

    public void setProduct (List<Product> product) {
        this.product = product;
    }

    public OrderStatus getOrderStatus () {
        return orderStatus;
    }

    public void setOrderStatus (OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getTotalPrice () {
        return totalPrice;
    }

    public void setTotalPrice (double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString () {
        return "Order{" +
                "orderId=" + orderId +
                ", product=" + product +
                ", orderStatus=" + orderStatus +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
