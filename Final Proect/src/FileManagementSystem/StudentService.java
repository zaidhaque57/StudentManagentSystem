package FileManagementSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StudentService {
    private List<Student> students = new ArrayList<>();

    public void addStudent(int rollNo, String name, int age, String course, double marks) throws Exception{

        boolean exists = students.stream().anyMatch(s -> s.getRollNo() == rollNo);
        if(exists) {
            throw new Exception("Student with Roll Number " + rollNo + " already exists!");
        }
        if (marks < 0 || marks > 100 ) {
            throw new Exception("Marks must be between 0 and 100!");
        }

        students.add(new Student(rollNo, name, age , course, marks));
        System.out.println("Student added Successfully!");
    }
    public void displayStudent() {
        if (students.isEmpty()) {
            System.out.println("No Student available!");
            return;
        }
        System.out.println("Roll   Name            Course     Marks   Grade");
        System.out.println("_________________________________________________");
        students.forEach(System.out::println);
    }

    public void serachStudentByRoll(int rollNo){
        students.stream()
                .filter(s -> s.getRollNo() == rollNo)
                .findFirst()
                .ifPresentOrElse(
                        s -> System.out.println("Found: " + s),
                        () -> System.out.println("Student not found!")
                );
    }
    public void SearchStudentByName(String name){
        long count = students.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .peek(s -> System.out.println("Found: " + s))
                .count();
        if (count > 0 ) System.out.println("No Student fount with name: " + name);
    }
    public void updateStudent(int rollNo, String newName, int newAge, String newCourse, double newMarks) {
        Optional<Student> StudentOpt = students.stream()
                .filter(s -> s.getRollNo()== rollNo)
                .findFirst();
        if(StudentOpt.isPresent()) {
            Student s = StudentOpt.get();
            s.setName(newName);
            s.setAge(newAge);
            s.setCourse(newCourse);
            s.setMarks(newMarks);
            System.out.println("Student Updated Successfully!");
        }else {
            System.out.println("Student not found!");
        }
    }
    public void deleteStudent(int rollNo) {
        boolean removed = students.removeIf(s -> s.getRollNo() == rollNo);
        if (removed) {
            System.out.println("Student deleted Successfully!");
        }else {
            System.out.println("Student not found!");
        }
    }
    public void showTopper() {
        students.stream()
                .max(Comparator.comparing(Student::getMarks))
                .ifPresentOrElse(
                        s -> System.out.println("Topper: " + s),
                        () -> System.out.println("No Student found!")
                );
    }
    public void showAverageMarks() {
        double avg = students.stream()
                .mapToDouble(Student::getMarks)
                .average()
                .orElse(0);
        System.out.println("Average Marks: " + avg);
    }
    public void countPassedStudents() {
        long passed = students.stream()
                .filter(s -> s.getMarks() >= 0)
                .count();
        System.out.println("Passed Marks: " + passed);
    }
    public void sortByName() {
        students.sort(Comparator.comparing(Student::getName));
        System.out.println("Students sorted by Name.");
        displayStudent();
    }
    public void sortByMarks() {
        // Sort descending (highest marks first)
        students.sort(Comparator.comparing(Student::getMarks).reversed());
        System.out.println("Students sorted by Marks.");
        displayStudent();
    }
    public void saveToFile() {
        try {
            FileManager.saveStudents(students);
            System.out.println("Students saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
    public void loadFromFile() {
        try {
            students = FileManager.loadStudents();
            System.out.println("Data loaded from file successfully.");
        } catch (IOException e) {
            System.out.println("Error loading file (or file not found): " + e.getMessage());
        }
    }
}
