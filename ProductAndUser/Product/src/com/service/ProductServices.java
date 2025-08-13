package com.service;

import com.entity.Product;
import com.entity.Users;

import java.util.*;

public class ProductServices implements ServiceInterface {

    static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Mobile", 1, 20000));
        productList.add(new Product(2, "Laptop", 1, 60000));
        productList.add(new Product(3, "HeadPhones", 1, 2000));
        productList.add(new Product(4, "PowerBank", 1, 5000));
        productList.add(new Product(5, "MobileCharger", 1, 500));

    }

    static Map<Users, HashSet<Product>> productMap = new LinkedHashMap<>();
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void addProduct () {//5
//        Users user = getUser();
//        productList.forEach(System.out::println);
//        HashSet<Product> productSet = new HashSet<>();
//        System.out.println("Enter number of products: ");
//        int n = scanner.nextInt();
//        for (int i = 0; i < n; i++) {
//            System.out.println("Enter Product Sr. No.: ");
//            int id = scanner.nextInt();
//            //productSet.add(new Product(prodname, quantity, price));
//            Product selectedProduct = productList.get(id);
//                if (productSet.isEmpty()) {
//                    productSet.add(productList.get(id));
//                } else if (productSet.contains(productList.get(id))) {
//                    for (Product product : productSet) {
//                        if (product.getProductId() == id) {
//                            product.setQuantity(product.getQuantity() + 1);
//                        }
//                    }
//
//
//            }
//        }
//        productMap.computeIfAbsent(user, k -> productSet);
//        System.out.println("Product Added");
        System.out.println("Enter number of products to add: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter Product Name: ");
            String prodname = scanner.next();
            System.out.println("Enter Product Quantity: ");
            int quantity = scanner.nextInt();
            System.out.println("Enter Product Price: ");
            double price = scanner.nextDouble();
            if (productList.contains(new Product(productList.size() + 1, prodname, quantity, price))) {
                System.out.println("Product already exists");
            } else {
                productList.add(new Product(productList.size() + 1, prodname, quantity, price));
                System.out.println("Product Added");
            }
        }

    }

    @Override
    public void updateProductPrice () {//4
//            Set<Product> productSet = productMap.get(getUser());
//            System.out.println("Enter Product Name: ");
//            String prodname = scanner.next();
//            System.out.println("Enter Product Price: ");
//            double price = scanner.nextDouble();
//            if (productSet != null) {
//                productSet.stream()
//                        .filter(product -> product.getName().equals(prodname))
//                        .findFirst().ifPresent(product -> product.setPrice(price));
//                System.out.println("Product Price Updated");
//            }
        System.out.println("Enter Product Name: ");
        String prodname = scanner.next();
        System.out.println("Enter Product Price: ");
        double price = scanner.nextDouble();
        if (productList.contains(new Product(productList.size() + 1, prodname, 1, price))) {
            productList.stream()
                    .filter(product -> product.getName().equals(prodname))
                    .findFirst().ifPresent(product -> product.setPrice(price));
            System.out.println("Product Price Updated");
        }
            else{
            System.out.println("Product not listed!");
        }
    }

    @Override
    public void updateProductQuantity () {
        Set<Product> productSet = productMap.get(getUser());
        System.out.println("Enter Product Name: ");
        String prodname = scanner.next();
        System.out.println("Enter Product Quantity: ");
        int quantity = scanner.nextInt();
        if (productSet != null) {
            productSet.stream()
                    .filter(product -> product.getName().equals(prodname))
                    .findFirst().ifPresent(product -> product.setQuantity(quantity));
            System.out.println("Product Quantity Updated");
        }

    }


    @Override
    public void removeProduct () {//3
        System.out.println("Enter Product Name: ");
        String prodname = scanner.next();
        if (productList != null) {
            productList.removeIf(product -> product.getName().equals(prodname));
            System.out.println("Product Removed");
        }

    }

    @Override
    public void removeUserandProduct () {
        productMap.remove(getUser());
        System.out.println("User and Product Removed");

    }

    @Override
    public void printProducts () { //2
        productList.forEach(System.out::println);

    }
    public List<Product> getProducts () {
        return productList;
    }

    @Override
    public void getProductsBasedOnPrice () {//1
//        productMap.get(getUser()).stream()
//                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
//                .forEach(System.out::println);
        productList.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .forEach(System.out::println);
    }


    private Users getUser () {
        Scanner scanner = new Scanner(System.in);
        Users u = new Users();
        System.out.println("Enter user Id: ");
        u.setId(scanner.nextInt());
        System.out.println("Enter user name: ");
        u.setName(scanner.next());
        return u;
    }
}


// Tasks :-
//
//Small Retailer want to maintain his users data like which user has purchase which product with
// its details like productname, price, quantity.
//
//Add User details and Its Product Details.
//Update the price or quantiy of product.
//Delete the product
//Delete the User and its Product Details
//Sort the product list based on price
//Get the Product Details based on User
//
//We will Cover the Map, List and Set here
// and also we cover the Sorting like Comparator and Comparable
// Maintain orders of product and order must be stored sequence.
//- Update its status after order is placed.
//Enhance the code using Java 8 features