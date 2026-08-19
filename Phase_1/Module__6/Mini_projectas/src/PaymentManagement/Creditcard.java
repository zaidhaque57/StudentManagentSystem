package PaymentManagement;

public class Creditcard extends Payment {
    @Override
    public void ProcessPayment(){
        System.out.println("Paid by using CreditCarc.");
    }
}
