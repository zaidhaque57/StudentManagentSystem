package LibraryManagementSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        Library myLibrary = new Library();

        myLibrary.addBook(new Book("B01","Efficetive" ,"Joshua Bloch"));
        myLibrary.addBook(new Book("B02","clean code", "Robert C. Martin"));

        Member testMember = new Member("Alex","M100");

        boolean isRunning = true;

        while(isRunning){
            System.out.println("==== Library Management System ===");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Display All Books");
            System.out.println("7. Exit");
            System.out.print("Select an option: ");

            try{
                int choice = sc.nextInt();
                sc.nextLine();

                if (choice == 1){
                    System.out.println("Enter Book Id: ");
                    String id = sc.nextLine();
                    System.out.println("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.println("Enter Author");
                    String author = sc.nextLine();
                    myLibrary.addBook(new Book(id, title, author));
                }
                else if (choice == 2){
                    System.out.println("Enter Book id to remove: ");
                    String id = sc.nextLine();
                    myLibrary.removeBook(id);
                }
                else if (choice == 3) {
                    System.out.println("Enter Keyword to search (Title) : ");
                    String keyword = sc.nextLine();
                    myLibrary.searchBook(keyword);
                }
                else if (choice == 4){
                    System.out.println("Enter Book ID to issue: ");
                    String id = sc.nextLine();
                    myLibrary.issueBook(id, testMember);
                }
                else if (choice == 5) {
                    System.out.println("Enter Book ID to Return: ");
                    String id = sc.nextLine();
                    myLibrary.returnBook(id);
                }
                else if (choice == 6) {
                    myLibrary.displayAlBook();
                } else if (choice == 7) {
                    System.out.println("Shutting down the System.Goodbye");
                    isRunning = false;
                }
                else {
                    System.out.println("Invaild selection. please choose (1-7): ");
                }
            }catch (InputMismatchException e){
                System.out.println("Error: Invalid input! Please enter numbers only for the menu.");
                sc.nextLine();
            }catch (LibraryException e){
                System.out.println("Operation Failed: " + e.getMessage());
            }catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
        sc.close();
    }
}
