package StudentDatabaseSystem;

import java.util.List;

public class StudentService {
    private final StudentDAO doa = new StudentDAO();

    public void addStudent(int id, String name, int age, String course, double marks) {
        Student newStudent = new Student(id, name, age, course, marks);
        if (doa.addStudent(newStudent)) {
            System.out.println("✅ Student added successfully to database.!");
        }else {
            System.out.println("❌ Failed to add student. (does this ID already exist?");
        }
    }

    public void viewAllStudent() {
        List<Student> students = doa.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("Database is empty.");
        }else {
            System.out.println("\n=== All Students ===");
            students.forEach(System.out::println);
        }
    }

    public void searchById(int id) {
        Student s = doa.searchById(id);
        if (s != null) {
            System.out.println("✅ Found: " + s);
        }else {
            System.out.println("❌ No student found with ID: " + id);
        }
    }

    public void searchByName(String name) {
        List<Student> students = doa.searchByName(name);
        if (students.isEmpty()) {
            System.out.println("❌ No student found with name: " + name);
        }else {
            System.out.println("\n---- Search Results -----");
            students.forEach(System.out::println);
        }
    }

    public void updateStudent(int id,String newName, String newCourse, double newMarks) {
        if (doa.updateStudent(id,newName,newCourse,newMarks)) {
            System.out.println("✅ Student updated successfully!");
        }else {
            System.out.println("❌ update failed. Student ID not found.");
        }
    }

    public void deleteStudent(int id) {
        if (doa.deleteStudent(id)) {
            System.out.println("✅ Student deleted successfully!");
        } else {
            System.out.println("❌ Deletion failed. Student ID not found.");
        }
    }

    public void showStatistics() {
        doa.displayStatistics();
    }
}
