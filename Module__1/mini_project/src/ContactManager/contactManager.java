package ContactManager;

import java.util.ArrayList;
import java.util.Scanner;

public class contactManager {
    public static void main(String[] args) {
        // Core tools requested
        ArrayList<String> contacts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int choice;

        // Menu Loop
        do {
            System.out.println("\n===== Contact Manager =====");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // CRITICAL: Consume the leftover newline character

            switch (choice) {
                case 1:
                    // FEATURE: Add Contact
                    System.out.print("Enter contact name (and phone number): ");
                    String newContact = scanner.nextLine();
                    contacts.add(newContact);
                    System.out.println("Success: Contact added!");
                    break;

                case 2:
                    // FEATURE: Display Contacts
                    if (contacts.isEmpty()) {
                        System.out.println("Your contact list is empty.");
                    } else {
                        System.out.println("\n--- Contact List ---");
                        // Using a standard for-loop to show human-readable numbers (1, 2, 3...)
                        for (int i = 0; i < contacts.size(); i++) {
                            System.out.println((i + 1) + ". " + contacts.get(i));
                        }
                    }
                    break;

                case 3:
                    // FEATURE: Search Contact
                    System.out.print("Enter a name to search for: ");
                    String searchName = scanner.nextLine();
                    boolean found = false;

                    System.out.println("Search Results:");
                    for (int i = 0; i < contacts.size(); i++) {
                        // toLowerCase() makes the search case-insensitive
                        if (contacts.get(i).toLowerCase().contains(searchName.toLowerCase())) {
                            System.out.println(" - " + contacts.get(i));
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("No matching contacts found.");
                    }
                    break;

                case 4:
                    // FEATURE: Update Contact
                    System.out.print("Enter the EXACT name of the contact you want to update: ");
                    String oldName = scanner.nextLine();

                    // indexOf returns -1 if the string is not found in the ArrayList
                    int index = contacts.indexOf(oldName);

                    if (index != -1) {
                        System.out.print("Enter the new details for this contact: ");
                        String updatedContact = scanner.nextLine();
                        // .set() replaces the item at the specified index
                        contacts.set(index, updatedContact);
                        System.out.println("Success: Contact updated!");
                    } else {
                        System.out.println("Error: Exact contact name not found.");
                    }
                    break;

                case 5:
                    // FEATURE: Delete Contact
                    System.out.print("Enter the EXACT name of the contact to delete: ");
                    String deleteName = scanner.nextLine();

                    // .remove(Object) returns true if it successfully found and deleted the item
                    if (contacts.remove(deleteName)) {
                        System.out.println("Success: Contact deleted!");
                    } else {
                        System.out.println("Error: Exact contact name not found.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting Contact Manager. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select a number between 1 and 6.");
            }
        } while (choice != 6);

        scanner.close();
    }
}