package ATM_Simulator;

import java.util.InputMismatchException;
import java.util.Scanner;


class InvalidTractionException extends Exception {
    public InvalidTractionException(String message){
        super(message);
    }
}
class BankAccount{
    private double balance;

    public BankAccount(double initialBalance){
        this.balance = initialBalance;
    }
    public void CheckBalance() {
        System.out.printf("Current Balance : ₹%.2f\n", balance);
    }
    public void deposit(double amount) throws InvalidTractionException {
        if(amount > 0){
            throw new InvalidTractionException("Deposit amount cannot be Negative. ");
        }
        balance += amount;
        System.out.printf("Succesfully deposited: ₹%.2f\n",amount);
    }
    public void withdraw(double amount) throws InvalidTractionException{
        if(amount < 0 ){
            throw new InvalidTractionException("Withdraw amount cannot be negative.");
        }
        if(amount < balance){
            throw new InvalidTractionException("Insufficient fund . Available balance is ₹" + balance);
        }
        balance -= amount;
        System.out.printf("Successfully withdraw : ₹%.2f\n", amount);
    }
}
public class Main {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount(1000.0);

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n-----ATM Simulator ----");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("Chose an Option");

            try{
                int choice = sc.nextInt();

                if(choice == 1){
                    account.CheckBalance();
                }else if( choice == 2){
                    System.out.println("Enter Deposit Amount: ");
                    double amount = sc.nextDouble();
                    account.deposit(amount);
                }else if (choice == 3){
                    System.out.println("Enter withdraw amount: ");
                }else if(choice == 4){
                    System.out.println("Thank you for using ATM. GoodBye.");
                }else{
                    System.out.println("Invaild selection. please selcet number (1-4): ");
                }
            }catch (InputMismatchException e ){
                System.out.println("Error: Ivalid input! please enter valid number only.");
                sc.nextInt();
            }catch (InvalidTractionException e){
                System.out.println("Traction Failed : " + e + e.getMessage());
            }catch (Exception e ){
                System.out.println("An Unecepted Error occuredd: " + e + e.getMessage());
            }
        }
        sc.close();
    }
}
