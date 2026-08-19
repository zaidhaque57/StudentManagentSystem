package PaymentManagement;

public class Main {
    public static void main(String[]args){

        Payment pay;

        pay = new UPI();
        pay.ProcessPayment();

        pay = new Creditcard();
        pay.ProcessPayment();

        pay = new NetBanking();
        pay.ProcessPayment();
    }
}
