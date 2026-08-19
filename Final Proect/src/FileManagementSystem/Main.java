package FileManagementSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentService service = new StudentService();

        // 11. Load Students when application starts
        service.loadFromFile();

        while (true) {
            System.out.println("\n================================");
            System.out.println("    Student Management System    ");
            System.out.println("================================");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Show Topper");
            System.out.println("7. Average Marks");
            System.out.println("8. Count Passed");
            System.out.println("9. Sort by Name");
            System.out.println("10. Sort by Marks");
            System.out.println("11. Save File");
            System.out.println("12. Load File");
            System.out.println("13. Exit");
            System.out.println("================================");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter Roll Number: ");
                        int roll = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Course: ");
                        String course = scanner.nextLine();
                        System.out.print("Enter Marks: ");
                        double marks = scanner.nextDouble();

                        try {
                            service.addStudent(roll, name, age, course, marks);
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case 2:
                        service.displayStudent();
                        break;
                    case 3:
                        System.out.println("Search by: 1. Roll No  2. Name");
                        int searchChoice = scanner.nextInt();
                        if (searchChoice == 1) {
                            System.out.print("Enter Roll No: ");
                            service.serachStudentByRoll(scanner.nextInt());
                        } else if (searchChoice == 2) {
                            System.out.print("Enter Name: ");
                            scanner.nextLine();
                            service.SearchStudentByName(scanner.nextLine());
                        } else {
                            System.out.println("Invalid search choice.");
                        }
                        break;
                    case 4:
                        System.out.print("Enter Roll Number to Update: ");
                        int uRoll = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter New Name: ");
                        String uName = scanner.nextLine();
                        System.out.print("Enter New Age: ");
                        int uAge = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter New Course: ");
                        String uCourse = scanner.nextLine();
                        System.out.print("Enter New Marks: ");
                        double uMarks = scanner.nextDouble();
                        if(uMarks < 0 || uMarks > 100) {
                            System.out.println("Invalid marks!");
                        } else {
                            service.updateStudent(uRoll, uName, uAge, uCourse, uMarks);
                        }
                        break;
                    case 5:
                        System.out.print("Enter Roll Number to Delete: ");
                        service.deleteStudent(scanner.nextInt());
                        break;
                    case 6:
                        service.showTopper();
                        break;
                    case 7:
                        service.showAverageMarks();
                        break;
                    case 8:
                        service.countPassedStudents();
                        break;
                    case 9:
                        service.sortByName();
                        break;
                    case 10:
                        service.sortByMarks();
                        break;
                    case 11:
                        service.saveToFile();
                        break;
                    case 12:
                        service.loadFromFile();
                        break;
                    case 13:
                        System.out.println("Exiting System... Don't forget to save!");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input. Please enter correct data format.");
                scanner.nextLine(); // Clear the bad input from scanner buffer
            }
        }
    }
}