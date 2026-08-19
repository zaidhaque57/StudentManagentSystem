package ATMSimulator;

public class ATM {
    private final BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }
    public void deposit(String userName, int amount) {
        account.deposit(userName, amount);
    }
    public void withdraw(String userName, int amount) {
        account.withdraw(userName, amount);
    }
    public void checkBalance(String userName, int amount) {
        System.out.println(userName + " checked balance. Current Balance: ₹" + account.getBalance());
    }
    public void printHistory() {
        account.printTranscationHistory();
    }
}