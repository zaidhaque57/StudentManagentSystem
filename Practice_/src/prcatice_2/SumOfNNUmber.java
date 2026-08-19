package prcatice_2;

import java.util.Scanner;
public class SumOfNNUmber {
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Number: ");

        int n = sc.nextInt();

        int Sum = 0;

        for(int i = 1; i<=n; i++){
            Sum +=i;
        }
        System.out.println("The Sum of first "+ n + " number is: "+ Sum);

        sc.close();
    }
}
