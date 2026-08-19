package StudentManagementSystem;

import java.sql.SQLException;
import java.util.List;

public class StudentService {

    private final StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public void addStudent(Student student) throws SQLException {
        if (student.getMarks() < 0 || student.getMarks() > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100.");
        }
        if (student.getAge() <= 0) {
            throw new IllegalArgumentException("Invalid Age.");
        }

        // FIXED: Used lowercase studentDAO instance instead of static StudentDAO class
        studentDAO.addStudent(student);
    }

    public List<Student> getAllStudents() throws SQLException {
        return studentDAO.getAllStudents();
    }

    public Student findStudent(int id) throws Exception {
        return studentDAO.getStudentById(id);
    }

    public void updateStudent(Student student) throws Exception {
        if (student.getMarks() < 0 || student.getMarks() > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100.");
        }
        studentDAO.updateStudent(student);
    }

    public void deleteStudent(int id) throws Exception {
        studentDAO.deleteStudent(id);
    }
}