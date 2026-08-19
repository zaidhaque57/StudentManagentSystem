package PaymentSystem;

interface Payment {
    void pay(double amount);
}
class UPI implements Payment{
    @Override
    public void pay(double amount){
        System.out.println("Processing UPI payment...\n");
        System.out.printf("₹%.2f paid Succesccfully via UPI.\n", amount);
    }
}
class CreditCard implements Payment{
    @Override
    public void pay(double amount){
        System.out.println("Processing Credit Card payment...\n");
        System.out.printf("₹%.2f Charged Succesccfully via Credit Card.\n", amount);
    }
}
class NetBanking implements Payment{
    @Override
    public void pay(double amount){
        System.out.println("Redirecting to Bank payment...\n");
        System.out.printf("₹%.2f deducted Succesccfully via NetBanking.\n", amount);
    }
}

public class Main {
    public static void main(String[]args){

        System.out.println("-----Individual Payment------");

        UPI gpay = new UPI();
        CreditCard visa = new CreditCard();
        NetBanking sbi = new NetBanking();

        gpay.pay(500);
        visa.pay(1500);
        sbi.pay(10000);

        Payment[] cardPayment = {new UPI(), new CreditCard(), new NetBanking()};

        double checkoutAmount = 999.99 ;

        for(Payment p : cardPayment){
            p.pay(checkoutAmount);
            System.out.println("------------------------");
        }

    }
}
