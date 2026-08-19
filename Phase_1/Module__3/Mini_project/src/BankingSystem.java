import java.util.Scanner;

public class BankingSystem {

    static double balance = 0.0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exist = false;

        System.out.println("Welcome to the interactive Banking System!");

        while(!exist){
            displayMenu();
            System.out.print("Enter your Choice (1-4): ");

            if(sc.hasNextInt()){
                int choice = sc.nextInt();

                switch (choice){

                    case 1:
                        deposit();
                        break;
                    case 2:
                        withdraw();
                        break;
                    case 3:
                        checkBalance();
                        break;
                    case 4:
                        System.out.println("Thanku you for using our services. GoodBye");
                        exist = true;
                        break;
                    default:
                        System.out.println("ERROR! INVAILD CHOICE. PLEASE SELECT AN OPTION BETWEEN 1 AND 4");
                }
            }else{
                System.out.println("Error: Invalid input. Please enter a number.");
                sc.next();
            }

        }
    }
//    Separate the Operation

    static void displayMenu(){
        System.out.println("\n=======================");
        System.out.println("        MAIN MENU        ");
        System.out.println("=========================");
        System.out.println("1.Deposit Funds");
        System.out.println("2. Withdraw Funds");
        System.out.println("3. Check Balance");
        System.out.println("4. Exist");
        System.out.println("=========================");
    }
    static void deposit(){
        System.out.print("Enter the Amount you Wish to Deposit: ₹ ");
        if(sc.hasNextDouble()){
            double amount = sc.nextDouble();
            if(amount > 0){
                balance += amount;
                System.out.printf("SUCCESS! YOU DEPOSITED ₹%.2f.\n", amount);
            }else{
                System.out.println("ERROR: DEPOSIT AMOUNT MUST BE GREATER THAN ZERO.");
            }
        }else{
            System.out.println("ERROR: INVALID AMOUNT ENTERED.");
            sc.next();
        }
    }
    static void withdraw() {
        System.out.print("Enter the amount you wish to withdraw: ₹");
        if (sc.hasNextDouble()) {
            double amount = sc.nextDouble();
            if(amount <= 0){
                System.out.println("ERROR: WITHDRAW AMOUNT MUST BE GREATER THAN ZERO.");
            }else if(amount > balance){
                System.out.println("ERROR: INSUFFICIENT FUNDS. YOUR CURRENT BALANCE IS ₹"+ balance);
            }else{
                balance -= amount;
                System.out.printf("SUCCESS! YOU WITHDRAW ₹%.2f.\n", amount);
            }
        }else{
            System.out.println("ERROR! INVALID AMOUNT ENTERED.");
            sc.next();
        }

    }
    static void checkBalance(){
        System.out.printf("Your Current Available Balance is $%.2f\n", balance);
    }
}
