package Polymorphism;

public class UPI  extends Payment{

    @Override
    void pay(){
        System.out.println("Paid using UPI");
    }
}

class CreditCard extends Payment{
    @Override
    void pay() {
        System.out.println("Paid using CreditCard");
    }
}
