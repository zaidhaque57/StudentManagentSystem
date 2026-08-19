import java.util.Scanner;

public class StudentScholarshipChecker {
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter you Name: ");
        String name = sc.nextLine();

        System.out.print("Enter your Marks: ");
        int marks = sc.nextInt();

        System.out.print("Enter your Family Income: ");
        int income = sc.nextInt();

        if (marks >= 80 && income <= 300000){
            System.out.println("Scholarship Approved");
            System.out.println("Congratulations "+ name);
        }else{
            System.out.println("You are not Eligible for Scholarship");
        }
    }
}
