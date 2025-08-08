package com.entity;

public class Product implements Comparable<Product>{
    private String name;
    private float quantity;
    private double price;

    public Product (String name, float quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }


    public String getName () {
        return name;
    }

    public float getQuantity () {
        return quantity;
    }

    public double getPrice () {
        return price;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setQuantity (float quantity) {
        this.quantity = quantity;
    }

    public void setPrice (double price) {
        this.price = price;
    }

    @Override
    public String toString () {
        return "Product{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo (Product o) {
         Double.compare(this.price, o.price);
        if(this.price>o.price){
            return -1;
        }else if(this.price<o.price){
            return 1;
        }else{
            return 0;
        }
    }
}
