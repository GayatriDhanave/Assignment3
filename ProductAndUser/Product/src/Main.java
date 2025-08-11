import com.entity.Product;
import com.service.RetailServices;
import com.service.ServiceInterface;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

   static Scanner scanner = new Scanner(System.in);
    static ServiceInterface productService = new RetailServices();
    public static void main (String[] args) {
        int choice = 0;
        do {
            printMenu();
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                        displayUserMenu();
                }
                case 2 -> {
                    displayProductMenu();
                }
                case 3 -> {
                    displayOrderMenu();
                }
                case 4 -> {
                    System.out.println("Exiting...");
                }
                default -> System.out.println("Invalid Choice");

            }
        } while (choice != 4);
    }

    private static void printMenu () {
        System.out.println("1. User");
        System.out.println("2. Product");
        System.out.println("3. Order");
        System.out.println("4. Exit");
    }

    private static void productMenu () {
        System.out.println("1. Add Product");
        System.out.println("2. Update Product Price");
        System.out.println("3. Update Product Quantity");
//        System.out.println("4. Remove Product");
//        System.out.println("5. Remove User and Product");
        System.out.println("4. Get Products");
        System.out.println("5. Get Products Based On Price");
        System.out.println("6. Exit");
    }

    static void displayProductMenu(){
        int choice=0;
        do {
            productMenu();
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    productService.addProduct();
                }
                case 2 -> {
                    productService.updateProductPrice();
                }
                case 3 -> {
                    productService.updateProductQuantity();
                }
                case 4 -> {
                    productService.removeProduct();
                }
                case 5 -> {
                    productService.removeUserandProduct();
                }
                case 6 ->{
                    productService.getProducts();
                }

                case 7 -> {
                    productService.getProductsBasedOnPrice();
                }
                case 8 -> {
                    System.out.println("Exiting...");
                }
                default -> System.out.println("Invalid Choice");

            }
        } while (choice != 8);
    }

    static void displayOrderMenu(){
        int choice=0;
        do {
            orderMenu();
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    productService.addProduct();
                }
                case 2 -> {
                    productService.updateProductPrice();
                }
                case 3 -> {
                    productService.updateProductQuantity();
                }
                case 4 -> {
                    productService.getProducts();
                }
                case 5 -> {
                    System.out.println("Exiting...");
                }
                default -> System.out.println("Invalid Choice");

            }
        } while (choice != 5);
    }
    private static void orderMenu () {
        System.out.println("1. Place Order");
        System.out.println("2. Update Order");
        System.out.println("3. Remove Order");
        System.out.println("4. Get Orders");
        System.out.println("5. Exit");
    }
    static void displayUserMenu(){
        int choice=0;
        do {
            userMenu();
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    productService.addProduct();
                }
                case 2 -> {
                    productService.updateProductPrice();
                }
                case 3 -> {
                    productService.updateProductQuantity();
                }
                case 4 -> {
                    productService.removeProduct();
                }
                case 5 -> {
                    System.out.println("Exiting...");
                }
                default -> System.out.println("Invalid Choice");

            }
        } while (choice != 5);
    }
    private static void userMenu () {
        System.out.println("1. Add User");
        System.out.println("2. Update User");
        System.out.println("3. Remove User");
        System.out.println("4. Get Users");
        System.out.println("5. Exit");
    }





}