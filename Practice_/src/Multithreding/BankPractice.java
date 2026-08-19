package Multithreding;

public class BankPractice {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        Thread depositor = new Thread(() -> {
            // FIXED: Changed i >= 5 to i < 5
            for (int i = 0; i < 5; i++) {
                account.deposit(100);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        });
        depositor.setName("Depositor");

        Thread withdrawer = new Thread(() -> {
            // FIXED: Changed i >= 5 to i < 5
            for (int i = 0; i < 5; i++) {
                account.withdraw(50);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        });
        withdrawer.setName("Withdraw");

        depositor.start();
        withdrawer.start();
    }
}