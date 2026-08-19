package LambdaFunction;

import java.util.Scanner;
import java.util.function.Predicate;

public class EvenNumberChecker {
    public static void main(String[]args){
        Predicate<Integer> isEven = number -> number % 2 == 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("==== Even Number Checker ====");
        System.out.print("Enter an integer: ");

        try{
            int input = Integer.parseInt(sc.nextLine().trim());
            if (isEven.test(input)){
                System.out.print(input + " is Even Number");
            }else{
                System.out.print(input + " is odd Number");
            }
        }catch (Exception e) {
            System.out.println("Error: Invalid input Please enter valid integer");
        }finally {
            sc.close();
        }
    }
}
