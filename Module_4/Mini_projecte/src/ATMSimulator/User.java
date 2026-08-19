package ATMSimulator;

public class User implements Runnable{
    private String name;
    private ATM atm;
    private String operation;
    private int amount;

    public User(String name, ATM atm, String operation, int amount) {
        this.name = name;
        this.atm = atm;
        this.operation = operation;
        this.amount = amount;
    }

    @Override
    public void run() {
        try{
            Thread.sleep((int) (Math.random()*100));
        }catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        switch (operation.toLowerCase()) {
            case "withdraw":
                atm.withdraw(name, amount);
                break;
            case "deposit":
                atm.deposit(name, amount);
                break;
            case "checkbalance":
                atm.checkBalance(name, amount);
                break;
            default:
                System.out.println("Invalid operation selected for " + name);
        }
    }
}
