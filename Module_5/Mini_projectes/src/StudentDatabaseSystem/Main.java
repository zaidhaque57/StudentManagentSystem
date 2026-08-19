package StudentDatabaseSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[]args) {

        DatabaseConnection.intializeDatabase();

        Scanner sc = new Scanner(System.in);
        StudentService Service = new StudentService();

        while (true) {
            System.out.println("\n===== Student JDBC Manager =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Show Statistics");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine(); // consume newline
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Age: ");
                        int age = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();
                        System.out.print("Enter Marks: ");
                        double marks = sc.nextDouble();
                        Service.addStudent(id, name, age, course, marks);
                        break;
                    case 2:
                        Service.viewAllStudent();
                        break;
                    case 3:
                        System.out.print("Search by (1) ID or (2) Name? ");
                        int type = sc.nextInt();
                        if (type == 1) {
                            System.out.print("Enter ID: ");
                            Service.searchById(sc.nextInt());
                        } else if (type == 2) {
                            System.out.print("Enter Name: ");
                            sc.nextLine();
                            Service.searchByName(sc.nextLine());
                        } else {
                            System.out.println("Invalid option.");
                        }
                        break;
                    case 4:
                        System.out.print("Enter ID of Student to Update: ");
                        int uId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter New Name: ");
                        String uName = sc.nextLine();
                        System.out.print("Enter New Course: ");
                        String uCourse = sc.nextLine();
                        System.out.print("Enter New Marks: ");
                        double uMarks = sc.nextDouble();
                        Service.updateStudent(uId, uName, uCourse, uMarks);
                        break;
                    case 5:
                        System.out.print("Enter ID of Student to Delete: ");
                        Service.deleteStudent(sc.nextInt());
                        break;
                    case 6:
                        Service.showStatistics();
                        break;
                    case 7:
                        System.out.println("Closing connection and exiting. Goodbye!");
                        sc.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input! Please enter the correct data type.");
                sc.nextLine(); // clear the invalid input
            }

        }
    }
}
