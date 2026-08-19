package SafeDivisonCalculator;

import java.util.Scanner;

public class SafeDivisionCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("==== Safe Division Calculator ====");

        while (true) {
            System.out.print("\nDo you want to perform a Division? (y/n): ");
            String choice = sc.nextLine().trim().toLowerCase();

            if(choice.equals("n") || choice.equals("no")) {
                System.out.println("Exiting Calculator. Goodbye!");
                break;
            }else if (!choice.equals("Y") && !choice.equals("yes")) {
                System.out.println("Invaild input ! please enter 'y' to continue or 'n' to exit. ");
                continue;
            }

            try{
                System.out.println("Enter the numerator (first number): ");
                double numerator = Double.parseDouble(sc.nextLine().trim());

                System.out.println("Enter the denominator (first number): ");
                double denominator = Double.parseDouble(sc.nextLine().trim());

                if (denominator == 0) {
                    throw new ArithmeticException("Cannot divide by zero!");
                }
                double result = numerator / denominator;
                System.out.println("Result: " + numerator + "/" +denominator+ " result" + result);
            }catch (NumberFormatException e){
                System.out.println("Error: Invalid number format . please enter numeric values only");
            }catch (ArithmeticException e) {
                System.out.println("Error" + e.getMessage());
            }
        }
        sc.close();
    }
}
