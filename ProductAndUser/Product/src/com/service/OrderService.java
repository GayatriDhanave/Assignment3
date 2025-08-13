package com.service;

import com.entity.Order;
import com.entity.Product;
import com.entity.Users;
import com.util.OrderStatus;

import java.util.*;

public class OrderService {
    static Map<Users, Order> orderMap = new LinkedHashMap<>();
    static List<Order> orderList = new LinkedList<>();
    Scanner scanner = new Scanner(System.in);
    ServiceInterface productServices = new ProductServices();
    UserService userService = new UserService();

    public void placeOrder () {
        System.out.println("Enter User Id: ");
        int uid = scanner.nextInt();
        System.out.println("Enter number of products: ");
        int n = scanner.nextInt();
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            productServices.printProducts();
            System.out.println("Enter Product Id: ");
            int pid = scanner.nextInt();

            for (Product product : productServices.getProducts()) {
                if (product.getProductId() == pid) {
                    System.out.println("Enter Product Quantity: ");
                    int quantity = scanner.nextInt();
                    product.setQuantity(quantity);
                    product.setTotalPrice(product.getPrice() * quantity);
                    productList.add(product);
//                    UUID uuid = UUID.randomUUID();
                }
            }
        }
        orderList.add(new Order(orderList.size() + 1, productList, OrderStatus.PENDING));
        if (orderMap.containsKey(uid)) {
            orderMap.get(uid).getProduct().addAll(productList);
        } else {
            orderMap.put(userService.getUsers().get(uid), new Order(orderList.size() + 1, productList, OrderStatus.PENDING));
        }

        System.out.println("Order Placed");
    }

    public void updateOrderStatus () {
        System.out.println("Enter Order Id: ");
        int oid = scanner.nextInt();
        System.out.println("Enter Order Status: ");
        String status = scanner.next();
//        orderList.stream()
//                .filter(order -> order.getOrderId() == oid)
//                .findFirst().ifPresent(order -> order.setOrderStatus(OrderStatus.valueOf(status)));
//        System.out.println("Order Status Updated");
        for (Map.Entry<Users, Order> entry : orderMap.entrySet()) {
            if (entry.getValue().getOrderId() == oid) {
                entry.getValue().setOrderStatus(OrderStatus.valueOf(status));
                System.out.println("Order Status Updated");
            }
        }
    }

    public void removeOrder () {
        System.out.println("Enter Order Id: ");
        int oid = scanner.nextInt();
        orderMap.forEach((k, v) -> {
            v.getProduct().removeIf(product -> product.getProductId() == oid);
        });
        System.out.println("Order Removed");
    }

    public void printOrders () {
        for (Map.Entry<Users, Order> entry : orderMap.entrySet()) {
            System.out.println("User: " + entry.getKey());
            System.out.println("Orders:" + entry.getValue());
        }
    }

    public void getOrdersBasedOnPrice () {
        orderMap.values().stream()
                .sorted((o1, o2) -> Double.compare(o2.getTotalPrice(), o1.getTotalPrice()))
                .forEach(System.out::println);
    }

    public void getOrdersBasedOnStatus () {
//        orderList.stream().filter(order -> order.getOrderStatus() == OrderStatus.PENDING).forEach(System.out::println);
        for (Map.Entry<Users, Order> entry : orderMap.entrySet()) {
            if (entry.getValue().getOrderStatus() == OrderStatus.PENDING) {
                System.out.println("User: " + entry.getKey());
                System.out.println("Orders:" + entry.getValue());
            }
        }
    }

    public void getOrdersBasedOnUser () {
        orderMap.forEach((k, v) -> {
            System.out.println("User: " + k);
            System.out.println("Orders:" + v);
        });
    }



}
