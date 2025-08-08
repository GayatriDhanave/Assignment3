import com.entity.Product;
import com.service.ProductService;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        ProductService productService = new ProductService();
        int choice = 0;

//        Set<Product> productSet = new HashSet<>();
        do {
            System.out.println("1. Add Product");
            System.out.println("2. Update Product Price");
            System.out.println("3. Update Product Quantity");
            System.out.println("4. Remove Product");
            System.out.println("5. Remove User and Product");
            System.out.println("6. Get Products");
            System.out.println("7. Get Products based on price");
            System.out.println("8. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter User Name: ");
                    String name = scanner.next();
                    System.out.println("Enter number of products: ");
                    int n = scanner.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.println("Enter Product Name: ");
                        String prodname = scanner.next();
                        System.out.println("Enter Product Quantity: ");
                        float quantity = scanner.nextFloat();
                        System.out.println("Enter Product Price: ");
                        double price = scanner.nextDouble();
                        Set<Product> productSet = new HashSet<>();
                        productSet.add(new Product(prodname, quantity, price));
                        productService.addProduct(name, productSet);

                    }
                    System.out.println("Product Added");
                    break;
                case 2:
                    System.out.println("Enter User Name: ");
                    name = scanner.next();
                    System.out.println("Enter Product Name: ");
                    String prodname = scanner.next();
                    System.out.println("Enter Product Price: ");
                    double price = scanner.nextDouble();
                    productService.updateProductPrice(name, price, prodname);
                    System.out.println("Product Price Updated");
                    break;
                case 3:
                    System.out.println("Enter User Name: ");
                    name = scanner.next();
                    System.out.println("Enter Product Name: ");
                    prodname = scanner.next();
                    System.out.println("Enter Product Quantity: ");
                    float quantity = scanner.nextFloat();
                    productService.updateProductQuantity(name, quantity, prodname);
                    System.out.println("Product Quantity Updated");
                    break;
                case 4:
                    System.out.println("Enter User Name: ");
                    name = scanner.next();
                    System.out.println("Enter Product Name: ");
                    prodname = scanner.next();
                    productService.removeProduct(name, prodname);
                    System.out.println("Product Removed");
                    break;
                case 5:
                    System.out.println("Enter User Name: ");
                    name = scanner.next();
                    productService.removeUserandProduct(name);
                    System.out.println("User and Product Removed");
                    break;
                case 6:
                    System.out.println("Enter User Name: ");
                    name = scanner.next();
                    productService.getProducts(name);

                    break;
                    case 7:
                        System.out.println("Enter User Name: ");
                        name = scanner.next();
                        productService.getProductsBasedOnPrice(name);
                        break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        } while (choice != 8);
    }

}