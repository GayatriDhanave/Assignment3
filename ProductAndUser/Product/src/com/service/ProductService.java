package com.service;

import com.entity.Product;

import java.util.*;

public class ProductService {
     Set<Product> productSet=new HashSet<>();
    static Map<String, Set<Product>> products = new HashMap<>();

    public void addProduct (String name, Set<Product> product) {
//        if(products.containsKey(name) ){
//            productSet = products.get(product.getName());
//        } else {
//            productSet = new HashSet<>();
//
//        }
//        productSet.add(product);
        if(!productSet.isEmpty() && products.containsKey(name)){
            productSet.addAll(product);

        }else {
            productSet=product;
        }
        products.put(name, productSet);
    }

    public void updateProductPrice (String name, double price, String prodname) {
        if(products.containsKey(name) ){
            productSet = products.get(name);
            for (Product product : productSet) {
                if (product.getName().equals(prodname)) {
                    product.setPrice(price);
                }
            }

        }

    }

    public void updateProductQuantity (String name, float quantity, String prodname) {
        if(products.containsKey(name) ){
            productSet = products.get(name);
            for (Product product : productSet) {
                if (product.getName().equals(prodname)) {
                    product.setQuantity(quantity);
                }
            }

        }

    }
    public void removeProduct (String name, String prodname) {
        if(products.containsKey(name) ){
            productSet = products.get(name);
            for (Product product : productSet) {
                if (product.getName().equals(prodname)) {
                    productSet.remove(product);
                }
            }

        }

    }
    public void removeUserandProduct(String name) {
        products.remove(name);
    }

    public void getProducts (String name) {
        if(products.containsKey(name) ){
            productSet = products.get(name);
            for (Product product : productSet) {
                System.out.println(product);
            }

        }
//        productSet = products.get(name);
//        if(productSet==null){
//            System.out.println("No products found");
//
//        }
        else{
        for (Product product : productSet) {
            System.out.println(product);
        }}
    }

    public void getProductsBasedOnPrice (String name) {
        Set<Product> product =products.get(name);
        List<Product> list = new ArrayList<>(product);
        Collections.sort(list);
        for (Product product1 : list) {
            System.out.println(product1);
        }




    }

}
