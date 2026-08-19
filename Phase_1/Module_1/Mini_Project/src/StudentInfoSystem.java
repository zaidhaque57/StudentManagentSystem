import java.util.Scanner;
public class StudentInfoSystem {
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Your Name: ");
        String Name = sc.nextLine();

        System.out.print("Enter Your Age: ");
        int age = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter your College Name: ");
        String college = sc.nextLine();

        System.out.print("Enter your Branch Name: ");
        String branch = sc.nextLine();

        System.out.print("Enter Your CGPA: ");
        double cgpa = sc.nextDouble();

        System.out.println("\n--- Student Details ---");
        System.out.println("Name: " + Name);
        System.out.println("Age: " + age);
        System.out.println("College Name: " + college);
        System.out.println("Branch Name: " + branch);
        System.out.println("CGPA: " + cgpa);

        sc.close();
    }
}
