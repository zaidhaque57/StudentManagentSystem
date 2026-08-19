package prcatice_2;

import java.util.Scanner;
public class MultiTable {
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number for the table: ");
        int num = sc.nextInt();

        System.out.println("___Multiplication Table of " + num + "____");

        for(int i = 1; i <= 10; i++){
            System.out.printf("%d * %d = %d\n",num, i, (num * i));
        }
        sc.close();
    }
}
