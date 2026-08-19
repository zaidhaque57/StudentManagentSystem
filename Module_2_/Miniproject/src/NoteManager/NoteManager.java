package NoteManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NoteManager {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            System.out.print("Enter your choice (1-6): ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    creatNote();
                    break;
                case "2":
                    writeNote(false);
                    break;
                case "3":
                    readNote();
                    break;
                case "4":
                    writeNote(true);
                    break;
                case "5":
                    deleteNote();
                    break;
                case "6":
                    System.out.println("Exiting Notes Manager. GoodBye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice please try btw (1-6)");
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("=== Note Manager ===");
        System.out.println("1. Create Note");
        System.out.println("2. Write Note");
        System.out.println("3. Read Note");
        System.out.println("4. Append Note");
        System.out.println("5. Delete Note");
        System.out.println("6. Exit");
        System.out.println("======================");
    }

    private static void creatNote() {
        System.out.print("Enter note name: ");
        String fileName = sc.nextLine();
        File file = new File(fileName);

        try {
            if (file.createNewFile()) {
                System.out.println("Success: Note created Successfully!");
            } else {
                System.out.println("Error: Note already exists!");
            }
        } catch (IOException e) {
            System.out.println("Error creating note: " + e.getMessage());
        }
    }

    // FIX: Added 'boolean append' parameter here
    private static void writeNote(boolean append) {
        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();
        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("Error : file does not exist");
            return;
        }
        System.out.print("Enter text to " + (append ? "append" : "write") + ": ");
        String content = sc.nextLine();

        // FIX: Added 'new' keyword before FileWriter
        try (FileWriter writer = new FileWriter(file, append)) {
            writer.write(content + "\n");
            System.out.println("Success: Note " + (append ? "appended" : "Saved") + " Successfully!");
        } catch (IOException e) {
            System.out.println("Error writing note: " + e.getMessage());
        }
    }

    // 3. Read Note
    private static void readNote() {
        System.out.print("Enter file name to read: ");
        String fileName = sc.nextLine();
        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("Error: File not found!");
            return;
        }

        System.out.println("\n--- Content of " + fileName + " ---");
        try (Scanner fileReader = new Scanner(file)) {
            if (!fileReader.hasNextLine()) {
                System.out.println("[File is empty]");
            }
            while (fileReader.hasNextLine()) {
                System.out.println(fileReader.nextLine());
            }
            System.out.println("---------------------------");
        } catch (IOException e) {
            System.out.println("Error reading note: " + e.getMessage());
        }
    }

    // 5. Delete Note
    private static void deleteNote() {
        System.out.print("Enter file name to delete: ");
        String fileName = sc.nextLine();
        File file = new File(fileName);

        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Success: Note deleted successfully!");
            } else {
                System.out.println("Error: Failed to delete the file.");
            }
        } else {
            System.out.println("Error: File does not exist.");
        }
    }
}