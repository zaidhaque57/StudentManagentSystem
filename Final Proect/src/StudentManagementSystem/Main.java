package StudentManagementSystem;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();
        StudentService service = new StudentService(dao);

        while (true) {
            System.out.println("\n===== Student Management =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            try {
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        addStudent(sc, service);
                        break;
                    case 2:
                        viewStudents(service);
                        break;
                    case 3:
                        searchStudent(sc, service);
                        break;
                    case 4:
                        updateStudent(sc, service);
                        break;
                    case 5:
                        deleteStudent(sc, service);
                        break;
                    case 6:
                        System.out.println("Goodbye!");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine();
            }
        }
    }

    private static void addStudent(Scanner sc, StudentService service) throws Exception {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Course: ");
        String course = sc.nextLine();

        System.out.print("Marks: ");
        double marks = sc.nextDouble();

        Student student = new Student(id, name, age, course, marks);
        service.addStudent(student);
        System.out.println("Student added successfully!");
    }

    private static void viewStudents(StudentService service) throws Exception {
        List<Student> students = service.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\nID | Name | Age | Course | Marks");
        System.out.println("--------------------------------");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void searchStudent(Scanner sc, StudentService service) throws Exception {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        Student student = service.findStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
        } else {
            System.out.println("Student found:");
            System.out.println(student);
        }
    }

    // FIXED: Added throws Exception and packaged the inputs into a new Student object
    private static void updateStudent(Scanner sc, StudentService service) throws Exception {
        System.out.print("Enter ID of Student to Update: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline

        System.out.print("Enter New Name: ");
        String name = sc.nextLine();

        System.out.print("Enter New Course: ");
        String course = sc.nextLine();

        System.out.print("Enter New Marks: ");
        double marks = sc.nextDouble();

        System.out.print("Enter New Age: ");
        int age = sc.nextInt();

        service.updateStudent(new Student(id, name, age, course, marks));
        System.out.println("Student updated successfully!");
    }

    private static void deleteStudent(Scanner sc, StudentService service) throws Exception {
        System.out.print("Enter student ID: ");
        int id = sc.nextInt();

        service.deleteStudent(id);
        System.out.println("Student deleted.");
    }
}