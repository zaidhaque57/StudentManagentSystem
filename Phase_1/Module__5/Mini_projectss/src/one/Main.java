package one;

class BankAccount{

    String AccountHolder;
    int AccountNumber;
    double Balance;
//    double amount;

    public BankAccount(String AccountHolder, int AccountNumber,double Balance){
        this.AccountHolder = AccountHolder;
        this.AccountNumber = AccountNumber;
        this.Balance = Balance;
    }

     void Deposit(double amount){
        if(amount > 0){
            System.out.println();
            System.out.printf("₹%.2f Deposit Successfully into Your Account.",amount);
            Balance += amount;
            System.out.printf("New Balamce : %.0f\n", Balance);
        }else{
            System.out.println("Error: Deposit amount must be greater than zero.");
        }
    }

     void withdraw(double amount){
        if(amount == 0){
            System.out.println("Error! amount must be greater than zero.");
        }else if(amount > Balance){
            System.out.println("Error: Insufficent Account Balance ");
        }else{
            System.out.println();
            System.out.printf("₹%.2f Withdraw Succesfull from Account s%.\n", amount);
            Balance -= amount;
            System.out.println("New Balance : " + Balance);
        }
    }

    void display(){
        System.out.println("\n========================");
        System.out.println("AccountHolder = " + AccountHolder);
        System.out.println("AccountNumber = " + AccountNumber);
        System.out.println("Balance = " + Balance);
    }
}

public class Main {
    public static void main(String[]args){

        BankAccount myAccount = new BankAccount("Zaid", 1234567, 5000);

        myAccount.display();

        myAccount.Deposit(1500);

    }

}
