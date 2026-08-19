package ATMSimulator;

public class Main {
    public static void main(String[]args) {

        BankAccount sharedAccount = new BankAccount(1000);

        ATM atm = new ATM(sharedAccount);

        Thread user1 = new Thread(new User("User 1", atm, "Withdraw", 500));
        Thread user2 = new Thread(new User("User 2", atm, "Withdraw", 300));
        Thread user3 = new Thread(new User("User 3", atm, "Deposit", 1500));
        Thread user4 = new Thread(new User("User 4", atm, "checkbalance", 0));

        user1.start();
        user2.start();
        user3.start();
        user4.start();

        try{
            user1.join();
            user2.join();
            user3.join();
            user4.join();
        }catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        atm.printHistory();
    }
}
