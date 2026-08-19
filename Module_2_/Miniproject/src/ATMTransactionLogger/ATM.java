package ATMTransactionLogger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ATM {
    private static double balance = 1000.00; // Initial starting balance
    private static final String TRANSACTION_FILE = "transactions.txt";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Ensure file exists on startup
        initTransactionFile();

        while (true) {
            printMenu();
            System.out.print("Enter your choice (1-4): ");

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1:
                        handleDeposit();
                        break;
                    case 2:
                        handleWithdrawal();
                        break;
                    case 3:
                        checkBalance();
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Error: Invalid option! Please select a number between 1 and 4.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input! Please enter a valid menu number.\n");
                logException("Invalid menu choice input: " + e.getMessage());
            }
        }
    }

    private static void printMenu() {
        System.out.println("===== ATM =====");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Balance");
        System.out.println("4. Exit");
        System.out.println("===============");
    }

    // 1. Deposit Handler
    private static void handleDeposit() {
        try {
            System.out.print("Enter amount to deposit: ₹");
            double amount = Double.parseDouble(scanner.nextLine().trim());

            if (amount <= 0) {
                System.out.println("Error: Deposit amount must be greater than $0.\n");
                logException("Failed deposit attempt: Non-positive amount (₹" + amount + ")");
                return;
            }

            balance += amount;
            String message = String.format("Deposited: ₹%.2f | New Balance: ₹%.2f", amount, balance);
            System.out.println("Success: " + message + "\n");
            logTransaction("DEPOSIT", amount, balance);

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid monetary value entered.\n");
            logException("Failed deposit attempt: Invalid number format");
        }
    }

    // 2. Withdrawal Handler
    private static void handleWithdrawal() {
        try {
            System.out.print("Enter amount to withdraw: $");
            double amount = Double.parseDouble(scanner.nextLine().trim());

            if (amount <= 0) {
                System.out.println("Error: Withdrawal amount must be greater than ₹0.\n");
                logException("Failed withdrawal attempt: Non-positive amount (₹" + amount + ")");
                return;
            }

            if (amount > balance) {
                System.out.println("Error: Insufficient funds! Current balance: ₹" + String.format("%.2f", balance) + "\n");
                logException("Failed withdrawal attempt: Insufficient balance (₹" + amount + " requested, ₹" + balance + " available)");
                return;
            }

            balance -= amount;
            String message = String.format("Withdrew: ₹%.2f | New Balance: ₹%.2f", amount, balance);
            System.out.println("Success: " + message + "\n");
            logTransaction("WITHDRAWAL", amount, balance);

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid monetary value entered.\n");
            logException("Failed withdrawal attempt: Invalid number format");
        }
    }

    // 3. Balance Check
    private static void checkBalance() {
        System.out.printf("Current Balance:₹%.2f%n%n", balance);
        logTransaction("BALANCE CHECK", 0.0, balance);
    }

    // Initialize or check transaction log file
    private static void initTransactionFile() {
        try {
            File file = new File(TRANSACTION_FILE);
            if (file.createNewFile()) {
                logRawMessage("--- ATM TRANSACTION LOG INITIALIZED ---");
            }
        } catch (IOException e) {
            System.out.println("Warning: Could not initialize log file.");
        }
    }

    // Writes clean transaction records to transactions.txt
    private static void logTransaction(String type, double amount, double currentBalance) {
        String timestamp = getCurrentTimestamp();
        String logEntry;

        if (type.equals("BALANCE CHECK")) {
            logEntry = String.format("[%s] %s - Current Balance: ₹%.2f", timestamp, type, currentBalance);
        } else {
            logEntry = String.format("[%s] %s - Amount: $%.2f | Remaining Balance: ₹%.2f",
                    timestamp, type, amount, currentBalance);
        }

        logRawMessage(logEntry);
    }

    // Logs exceptions and errors to transactions.txt
    private static void logException(String errorDetails) {
        String timestamp = getCurrentTimestamp();
        String logEntry = String.format("[%s] ERROR - %s", timestamp, errorDetails);
        logRawMessage(logEntry);
    }

    // Low-level helper to write lines to file
    private static void logRawMessage(String message) {
        try (FileWriter fw = new FileWriter(TRANSACTION_FILE, true);
             PrintWriter out = new PrintWriter(fw)) {
            out.println(message);
        } catch (IOException e) {
            System.out.println("Failed to write to transaction log file: " + e.getMessage());
        }
    }

    private static String getCurrentTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}