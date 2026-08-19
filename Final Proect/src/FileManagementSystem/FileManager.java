package FileManagementSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final String FILE_NAME = "students.txt";

    public static void saveStudents(List<Student> students) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                writer.write(s.getRollNo() + "," + s.getName() + "," + s.getAge() + "," +
                        s.getCourse() + "," + s.getMarks() + "," + s.getGrade());
                writer.newLine();
            }
        }
    }

    public static List<Student> loadStudents() throws IOException {
        List<Student> students = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return students; // Return empty list if file doesn't exist yet
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    int rollNo = Integer.parseInt(data[0]);
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    String course = data[3];
                    double marks = Double.parseDouble(data[4]);
                    char grade = data[5].charAt(0);
                    students.add(new Student(rollNo, name, age, course, marks, grade));
                }
            }
        }
        return students;
    }
}