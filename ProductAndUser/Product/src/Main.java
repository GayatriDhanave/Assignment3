import com.service.OrderService;
import com.service.ProductServices;
import com.service.ServiceInterface;
import com.service.UserService;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ServiceInterface productService = new ProductServices();
    static UserService userService = new UserService();
    static OrderService orderService = new OrderService();

    public static void main (String[] args) {
        int choice = 0;
        do {
            printMenu();
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> displayUserMenu();

                case 2 -> displayProductMenu();
                case 3 -> displayOrderMenu();
                case 4 -> System.out.println("Exiting...");
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

//        System.out.println("4. Remove Product");
//        System.out.println("5. Remove User and Product");
        System.out.println("3. Remove Products");
        System.out.println("4. Get Products");
        System.out.println("5. Get Products Based On Price");
        System.out.println("6. Exit");
    }

    static void displayProductMenu () {
        int choice = 0;
        do {
            productMenu();
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> productService.addProduct();

                case 2 -> productService.updateProductPrice();

                case 3 -> productService.removeProduct();

//                case 4 -> {
//                    productService.removeUserandProduct();
//                }
                case 4 -> productService.printProducts();


                case 5 -> productService.getProductsBasedOnPrice();

                case 6 -> System.out.println("Exiting...");

                default -> System.out.println("Invalid Choice");

            }
        } while (choice != 6);
    }

    static void displayOrderMenu () {
        int choice = 0;
        do {
            orderMenu();
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    orderService.placeOrder();
                }
                case 2 -> {
                    orderService.updateOrderStatus();
                }
                case 3 -> {
                    orderService.removeOrder();
                }
                case 4 -> {
                    orderService.printOrders();
                }
                case 5 -> {
                    orderService.getOrdersBasedOnPrice();
                }
                case 6 -> {
                    orderService.getOrdersBasedOnStatus();
                }
                case 7 -> {
                    orderService.getOrdersBasedOnUser();
                }
                case 8 -> {
                    System.out.println("Exiting...");
                }
                default -> System.out.println("Invalid Choice");

            }
        } while (choice != 8);
    }

    private static void orderMenu () {
        System.out.println("1. Place Order");
        System.out.println("2. Update Order status");
        System.out.println("3. Remove Order");
        System.out.println("4. Get Orders");
        System.out.println("5. Get Orders Based On Price");
        System.out.println("6. Get Orders Based On Status");
        System.out.println("7. Get Orders Based On User");
        System.out.println("8. Exit");
    }

    static void displayUserMenu () {
        int choice = 0;
        do {
            userMenu();
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    userService.addUser();
                }
                case 2 -> {
                    userService.updateUser();
                }
                case 3 -> {
                    userService.removeUser();
                }
                case 4 -> {
                    userService.printUsers();
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