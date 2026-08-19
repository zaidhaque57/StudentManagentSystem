package ATMSimulator;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private int balance;
    private final List<String> transcationHistory;

    public BankAccount(int intialBalance) {
        this.balance = intialBalance;
        this.transcationHistory = new ArrayList<>();
        transcationHistory.add("Account intialized with balance:  ₹" + intialBalance);
    }

    public synchronized void deposit(String username, int amount) {
        System.out.println(username + " is trying to deposit ₹" + amount + "...");
        balance += amount;

        String record = username + " Succesfully deposited ₹" + amount + " . New Balnace" + balance;
        System.out.println(record);
    }

    public synchronized void withdraw(String userName, int amount) {
        System.out.println(userName + " is trying to withdraw ₹" + amount + "...");

        if(balance >= amount) {
            balance -= amount;
            String record = userName + " successfully withdrew ₹" + amount + ". New Balance: ₹" + balance;
            transcationHistory.add(record);
            System.out.println(record);
        }else{
            String record = userName + " failed tp withdraw ₹" + amount + "(Insufficient Funds). Current Balance: ₹" + balance;
            transcationHistory.add(record);
            System.out.println(record);
        }
    }

    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void printTranscationHistory() {
        System.out.println("\n===========================");
        System.out.println("       TRANSACTION HISTORY      ");
        System.out.println("==============================");
        for (String record : transcationHistory){
            System.out.println(" -> " + record);
        }
        System.out.println("================================");
    }
}
