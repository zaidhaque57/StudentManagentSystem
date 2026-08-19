package PaymentManagement;

public class NetBanking extends Payment{
    @Override
    public void ProcessPayment(){
        System.out.println("Paid by using NetBanking.");
    }
}
