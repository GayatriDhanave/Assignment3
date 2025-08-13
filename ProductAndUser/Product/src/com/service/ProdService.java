package com.service;

import com.entity.Product;

import java.util.*;

public class ProdService implements ServiceInterface{
//    map.computeIfAbsent(key, k -> new HashSet<V>()).add(v)

    Set<Product> productSet = new HashSet<>();
    static Map<String, Set<Product>> products = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    public void addProduct () {
        Set<Product> productSet = new HashSet<>();
        System.out.println("Enter User Name: ");
        String name = scanner.next();
        System.out.println("Enter number of products: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter Product Name: ");
            String prodname = scanner.next();
            System.out.println("Enter Product Quantity: ");
            int quantity = scanner.nextInt();
            System.out.println("Enter Product Price: ");
            double price = scanner.nextDouble();
//            productSet.add(new Product(prodname, quantity, price));
        }
        products.put(name, productSet);
        System.out.println("Product Added");
    }

    public void updateProductPrice () {

        System.out.println("Enter User Name: ");
        String name = scanner.next();
        System.out.println("Enter Product Name: ");
        String prodname = scanner.next();
        System.out.println("Enter Product Price: ");
        double price = scanner.nextDouble();
        if (products.containsKey(name)) {
            productSet = products.get(name);
            for (Product product : productSet) {
                if (product.getName().equals(prodname)) {
                    product.setPrice(price);
                    System.out.println("Product Price Updated");
                }
            }
        }
    }

    public void updateProductQuantity () {
        System.out.println("Enter User Name: ");
        String name = scanner.next();
        System.out.println("Enter Product Name: ");
        String prodname = scanner.next();
        System.out.println("Enter Product Quantity: ");
        int quantity = scanner.nextInt();
        if (products.containsKey(name)) {
            productSet = products.get(name);
            for (Product product : productSet) {
                if (product.getName().equals(prodname)) {
                    product.setQuantity(quantity);
                    System.out.println("Product Quantity Updated");
                }
            }
        }
    }

    public void removeProduct () {
        System.out.println("Enter User Name: ");
        String name = scanner.next();
        System.out.println("Enter Product Name: ");
        String prodname = scanner.next();
        if (products.containsKey(name)) {
            productSet = products.get(name);
            for (Product product : productSet) {
                if (product.getName().equals(prodname)) {
                    productSet.remove(product);
                    System.out.println("Product Removed");
                }
            }
        }
    }

    public void removeUserandProduct () {
        System.out.println("Enter User Name: ");
        String name = scanner.next();
        products.remove(name);
        System.out.println("User and Product Removed");
    }

    public void printProducts () {
        System.out.println("Enter User Name: ");
        String name = scanner.next();
        if (products.containsKey(name)) {
            productSet = products.get(name);
            for (Product product : productSet) {
                System.out.println(product);
            }
        } else {
            System.out.println("User Not Found");
        }
    }

    public void getProductsBasedOnPrice () {
        System.out.println("Enter User Name: ");
        String name = scanner.next();
        Set<Product> product = products.get(name);
//        Collections.sort(product);-> error Required:List<T> Provided:Set<Product>
//        List<Product> list = new ArrayList<>(product);
//        ->using normal Comparator class I cannot sort the
//        set so used stream api to do the same.
        List<Product> sortedList = product.stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .toList();
//        using stream api to sort ->set can be directly passed as parameter.
//        firstly converted set to stream. Applied sorting using comparator.
//        Then collected the stream to list.
        for (Product product1 : sortedList) {
            System.out.println(product1);
        }
    }

    @Override
    public List<Product> getProducts () {
        return List.of();
    }

}
