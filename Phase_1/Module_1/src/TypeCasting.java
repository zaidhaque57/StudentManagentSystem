public class TypeCasting {
    public static void main(String[]args){

//        1.Implicit (Automatic)

        int number = 25;
        double value = number;

        System.out.println(value);
    }
}

public static void main(String[]args){

//    2.Expliciit (Manual)

    double price = 199.99;
    int value = (int) price;

    System.out.println(value);
}