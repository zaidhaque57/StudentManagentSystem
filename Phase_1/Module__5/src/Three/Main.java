package Three;

class BankAccount{

    private double balance;

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
        }
    }
    public void withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
        }else{
            System.out.println("Insufficient Balance");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class Main {
    public static void main(String[]args){

        BankAccount account = new BankAccount();

        account.deposit(5000);
        account.withdraw(1200);
        System.out.println(account.getBalance());
    }
}
