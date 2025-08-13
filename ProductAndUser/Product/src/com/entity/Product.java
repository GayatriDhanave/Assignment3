package com.entity;

import java.util.Objects;

public class Product implements Comparable<Product>{


//    ?order class ->product id && user details status
//    userlist
    private long productId;
    private String name;
    private int quantity;
    private double price;
    private double totalPrice;
//    private OrderStatus orderStatus;


    public Product (long productId, String name, int quantity, double price) {
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = quantity * price;
    }

    public long getProductId () {
        return productId;
    }

    public void setProductId (long productId) {
        this.productId = productId;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getQuantity () {
        return quantity;
    }

    public void setQuantity (int quantity) {
        this.quantity = quantity;
    }

    public double getPrice () {
        return price;
    }

    public void setPrice (double price) {
        this.price = price;
    }

    public double getTotalPrice () {
        return totalPrice;
    }

    public void setTotalPrice (double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals (Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(getName(), product.getName());
    }

    @Override
    public int hashCode () {
        return Objects.hashCode(getName());
    }

    @Override
    public int compareTo (Product o) {
         return Double.compare(this.price, o.price);

    }
    @Override
    public String toString () {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
//                ", price=" + price +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
