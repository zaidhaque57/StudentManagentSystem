package LibraryCatalog;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LibraryCatalog {
    public static void main(String[]args){
        HashMap<Integer, String> catalog = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        int choice;

        do{
            System.out.println("\n===== Library Catalog =====");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display All Book");
            System.out.println("5. Exit");
            System.out.println("===========================");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter the unqie Book ID (Number): ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    if(catalog.containsKey(id)){
                        System.out.println("Error : A Book with ID" + id + "Already exists.");
                    }else{
                        System.out.print("Enter the Book Title: ");
                        String title = sc.nextLine();

                        catalog.put(id, title);
                        System.out.println("Successfully added Book");
                    }
                    break;
                case 2:
                    System.out.print("Enter the Book ID to remove Book: ");
                    int removeId = sc.nextInt();
                    sc.nextLine();

                    String removeTitle = catalog.remove(removeId);

                    if (removeTitle != null){
                        System.out.println("Successfully remove Book " + removeTitle + "from Catalog");
                    }else{
                        System.out.println("Error: Book ID not found");
                    }
                    break;
                case 3:
                    System.out.println("Enter a title or keyword to search for: ");
                    String Keyword = sc.nextLine().toLowerCase();
                    boolean found = false;

                    System.out.println("Search Results:");
                    for(Map.Entry<Integer, String> entry : catalog.entrySet()){
                        if(entry.getValue().toLowerCase().contains(Keyword)){
                            System.out.println("ID:" + entry.getKey() + " | Title: " + entry.getValue());
                            found = true;
                        }
                    }
                    if(!found){
                        System.out.println("No Books matched your search.");
                    }
                    break;
                case 4:
                    if (catalog.isEmpty()){
                        System.out.println("The Library Catalog is currently empty.");
                    }else{
                        System.out.println("\n==== All Books ===");
                        for(Map.Entry<Integer, String> entry : catalog.entrySet()){
                            System.out.println("ID :" + entry.getKey() + " | Title : " + entry.getValue());
                        }
                    }
                    break;
                case 5:
                    System.out.println("Exiting Library Catalog. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a number between 1 and 5.");
            }
        }while (choice != 5);

        sc.close();
    }

}
