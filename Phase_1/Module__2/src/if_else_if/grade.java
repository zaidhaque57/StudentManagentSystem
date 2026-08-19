package if_else_if;
import java.util.Scanner;
public class grade {
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your Grade: ");

        int marks = sc.nextInt();

        if(marks >= 90){
            System.out.println("Grade 'A' ");
        }else if (marks >= 80){
            System.out.println("Garde 'B' ");
        }else if (marks >= 70) {
            System.out.println("Garde 'C' ");
        }else if (marks >= 60){
            System.out.println("Grade 'D' ");
        }else {
            System.out.println("Fail");
        }
        sc.close();
    }
}
