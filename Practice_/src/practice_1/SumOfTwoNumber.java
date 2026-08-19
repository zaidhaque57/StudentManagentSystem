package practice_1;

import java.util.Scanner;
public class SumOfTwoNumber {
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter First Number: ");
        int a = sc.nextInt();

        System.out.print("Enter Second Number: ");
        int b = sc.nextInt();

        int sum  = a + b;

        System.out.println("Sum "+ sum);

        sc.close();
    }
}

