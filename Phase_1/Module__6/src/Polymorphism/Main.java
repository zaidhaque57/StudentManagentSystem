package Polymorphism;

public class Main {
    public static void main(String[]args){

        Payment payment;

        payment = new UPI();
        payment.pay();

        payment = new CreditCard();
        payment.pay();
    }
}
