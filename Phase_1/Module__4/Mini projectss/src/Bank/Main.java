package Bank;

class BankAccount {
    String accountHolder;
    String accountNumber;
    double balance;

    public BankAccount(String holder, String number, double initialBalance){
        accountHolder = holder;
        accountNumber = number;
        balance = initialBalance;
    }

    void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.printf("$%.2f deposit Successfully into account %s.\n", amount, accountNumber);
        }else{
            System.out.println("Error: Depsoit amount must be greater than Zero");
        }
    }

    void withdraw(double amount){
        if(amount <= 0){
            System.out.println("Error : withdraw amount must be greater than zero.");
        }else if(amount > balance){
            System.out.println("Error : Insufficent Account balance ");
        }else{
            balance -= amount;
            System.out.printf("$%.2f withdrawn successfully from account %s.\n", amount, accountNumber);
        }
    }

    void displayBalance() {
        System.out.println("-----------------------------------");
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Account Number : " + accountNumber);
        System.out.printf("Current Balance: $%.2f\n", balance);
        System.out.println("-----------------------------------");
    }
}

public class Main{
    public static void main(String []args){

        // 1. Create two separate bank accounts
        BankAccount account1 = new BankAccount("Alice Smith", "BAT-10023", 500.00);
        BankAccount account2 = new BankAccount("Bob Jones", "BAT-10099", 150.00);

        // Display initial states
        System.out.println("=== INITIAL ACCOUNT DETAILS ===");
        account1.displayBalance();
        account2.displayBalance();

        // 2. Perform operations on Account 1 (Alice)
        System.out.println("\n=== OPERATIONS ON ALICE'S ACCOUNT ===");
        account1.deposit(250.50);
        account1.withdraw(100.00);
        account1.displayBalance();

        // 3. Perform operations on Account 2 (Bob)
        System.out.println("\n=== OPERATIONS ON BOB'S ACCOUNT ===");
        account2.deposit(50.00);
        account2.withdraw(300.00); // This should fail due to insufficient funds
        account2.withdraw(75.25);
        account2.displayBalance();
    }
}