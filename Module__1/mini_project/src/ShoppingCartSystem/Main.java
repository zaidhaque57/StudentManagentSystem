package ShoppingCartSystem;

import ShoppingCartSystem.Product;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // The HashMap maps the Product ID (Integer) to the actual Product object
        HashMap<Integer, Product> cart = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n===== Shopping Cart System =====");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Search Product");
            System.out.println("4. Display Products");
            System.out.println("5. Calculate Total Price");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the leftover newline

            switch (choice) {
                case 1:
                    // FEATURE: Add Product
                    System.out.print("Enter Product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (cart.containsKey(id)) {
                        System.out.println("Error: A product with ID " + id + " is already in the cart.");
                    } else {
                        System.out.print("Enter Product Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter Product Price: ");
                        double price = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline

                        // Create the new Product object and put it in the map
                        Product newProduct = new Product(id, name, price);
                        cart.put(id, newProduct);
                        System.out.println("Success: " + name + " added to the cart!");
                    }
                    break;

                case 2:
                    // FEATURE: Remove Product
                    System.out.print("Enter the Product ID to remove: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    // remove() returns the deleted Product object (or null if not found)
                    Product removedProduct = cart.remove(removeId);

                    if (removedProduct != null) {
                        System.out.println("Success: Removed '" + removedProduct.getProductName() + "' from the cart.");
                    } else {
                        System.out.println("Error: Product ID not found in the cart.");
                    }
                    break;

                case 3:
                    // FEATURE: Search Product
                    System.out.print("Enter a product name to search for: ");
                    String keyword = scanner.nextLine().toLowerCase();
                    boolean found = false;

                    System.out.println("Search Results:");
                    // Iterate through the values (the Product objects) in the map
                    for (Product p : cart.values()) {
                        if (p.getProductName().toLowerCase().contains(keyword)) {
                            // This automatically calls our custom toString() method!
                            System.out.println(" - " + p);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("No products matched your search.");
                    }
                    break;

                case 4:
                    // FEATURE: Display Products
                    if (cart.isEmpty()) {
                        System.out.println("Your shopping cart is empty.");
                    } else {
                        System.out.println("\n--- Items in Cart ---");
                        for (Product p : cart.values()) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 5:
                    // FEATURE: Calculate Total Price
                    if (cart.isEmpty()) {
                        System.out.println("The cart is empty. Total: $0.00");
                    } else {
                        double total = 0.0;
                        for (Product p : cart.values()) {
                            total += p.getPrice(); // Extracting the price using our getter
                        }
                        System.out.println("-------------------------");
                        System.out.println("Total Price: ₹" + String.format("%.2f", total));
                        System.out.println("-------------------------");
                    }
                    break;

                case 6:
                    System.out.println("Exiting Shopping Cart System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select a number between 1 and 6.");
            }
        } while (choice != 6);

        scanner.close();
    }
}