package prcatice_2;
import java.util.Scanner;
public class FactorialNum {
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Number: ");
        int number = sc.nextInt();
        long factorial = 1;

        for(int i=1; i<=number; i++){
            factorial *=i;
        }
        System.out.println("The Factorial of "+ number + " is "+ factorial);
        sc.close();
    }
}
