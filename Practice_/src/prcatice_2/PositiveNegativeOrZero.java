package prcatice_2;
import java.util.Scanner;
public class PositiveNegativeOrZero {
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Number: ");

        int num = sc.nextInt();

        if (num < 0 ){
            System.out.println("Negative Number ");
        }else if (num > 0 ){
            System.out.println("Positive Number ");
        }else{
            System.out.println("Zero");
        }
    }
}
