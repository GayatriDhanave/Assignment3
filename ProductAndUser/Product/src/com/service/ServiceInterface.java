package com.service;

import com.entity.Product;

import java.util.List;

public interface ServiceInterface {
    public void addProduct ();
    public void updateProductPrice () ;

    public void updateProductQuantity () ;

    public void removeProduct () ;

    void removeUserandProduct ();

    void printProducts ();

    void getProductsBasedOnPrice ();

    List<Product> getProducts();
}
