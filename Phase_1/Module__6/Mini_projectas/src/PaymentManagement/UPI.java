package PaymentManagement;

public class UPI extends Payment{
    @Override
    public void ProcessPayment(){
        System.out.println("Paid by using UPI.");
    }
}

