import java.util.Scanner;

public class MenuDrivenCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== Calculator =====");
        System.out.println("1. ADD");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.print("Choose Option (1-4): ");

        // 1. Get the menu choice first
        int choice = sc.nextInt();

        // 2. Only ask for numbers if the user picked a valid option
        if (choice >= 1 && choice <= 4) {
            System.out.print("Enter Number 1: ");
            int n1 = sc.nextInt();
            System.out.print("Enter Number 2: ");
            int n2 = sc.nextInt();

            // 3. Perform the correct operation based on the choice
            switch (choice) {
                case 1:
                    System.out.println("Result (Sum): " + (n1 + n2));
                    break;
                case 2:
                    System.out.println("Result (Difference): " + (n1 - n2));
                    break;
                case 3:
                    System.out.println("Result (Product): " + (n1 * n2));
                    break;
                case 4:
                    // Check to handle division by zero error
                    if (n2 == 0) {
                        System.out.println("Error: Cannot divide by zero!");
                    } else {
                        // Cast to double if you want decimal results (e.g., 5 / 2 = 2.5)
                        System.out.println("Result (Quotient): " + ((double) n1 / n2));
                    }
                    break;
            }
        } else {
            System.out.println("Invalid Input! Please choose a number between 1 and 4.");
        }

        sc.close(); // Good practice to close the scanner
    }
}