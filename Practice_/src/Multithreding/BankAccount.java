package Multithreding;

public class BankAccount {
    private int balance = 0;

    public synchronized void deposit(int amount) {
        System.out.println(Thread.currentThread().getName() + " deposited ₹" + amount);
        // FIXED: Changed =+ to +=
        balance += amount;
        System.out.println("New Balance after deposit ₹" + balance);
    }

    public synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " is trying to withdraw ₹" + amount);

        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdraw successful! new Balance: ₹" + balance);
        } else {
            // Updated to ₹ symbol for consistency
            System.out.println("Insufficient funds for withdrawal. Current Balance: ₹" + balance);
        }
    }

    public int getBalance() {
        return balance;
    }
}