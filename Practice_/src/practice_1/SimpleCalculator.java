package practice_1;

import java.util.Scanner;
public class SimpleCalculator {
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter First Number: ");
        double a = sc.nextDouble();

        System.out.print("Enter Second Number: ");
        double b = sc.nextDouble();

        System.out.println("Addition = " + (a + b));
        System.out.println("Subraction = " + (a - b));
        System.out.println("Multipication = " + (a * b));
        if (b != 0){
            System.out.println("Division = " + (a/b));
        }else{
            System.out.println("Division by Zero is not Allowed");
        }

        sc.close();
    }
}