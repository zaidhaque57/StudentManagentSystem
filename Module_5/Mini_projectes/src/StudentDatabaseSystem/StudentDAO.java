package StudentDatabaseSystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public boolean addStudent(Student student) {
        String sql = "INSERT INTO students (id, name, age, course, marks) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, student.getId());
            pstmt.setString(2, student.getName());
            pstmt.setInt(3, student.getAge());
            pstmt.setString(4, student.getCourse());
            pstmt.setDouble(5, student.getMarks());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
            return false;
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"), rs.getString("name"), rs.getInt("age"),
                        rs.getString("course"), rs.getDouble("marks")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving students: " + e.getMessage());
        }
        return students;
    }

    public Student searchById(int id) {
        String sql = "SELECT * FROM students WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Student(rs.getInt("id"), rs.getString("name"),
                        rs.getInt("age"), rs.getString("course"), rs.getDouble("marks"));
            }
        } catch (SQLException e) {
            System.out.println("Error searching by ID: " + e.getMessage());
        }
        return null;
    }

    public List<Student> searchByName(String name) {
        List<Student> students = new ArrayList<>();
        // Use LIKE for partial matches (e.g., searching "Am" finds "Aman")
        String sql = "SELECT * FROM students WHERE name LIKE ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                students.add(new Student(rs.getInt("id"), rs.getString("name"),
                        rs.getInt("age"), rs.getString("course"), rs.getDouble("marks")));
            }
        } catch (SQLException e) {
            System.out.println("Error searching by name: " + e.getMessage());
        }
        return students;
    }

    public boolean updateStudent(int id, String name, String course, double marks) {
        String sql = "UPDATE students SET name = ?, course = ?, marks = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, course);
            pstmt.setDouble(3, marks);
            pstmt.setInt(4, id);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
            return false;
        }
    }

    public void displayStatistics() {
        String sql = "SELECT COUNT(*) as total, AVG(marks) as average, MAX(marks) as highest, MIN(marks) as lowest FROM students";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                System.out.println("\n--- Database Statistics ---");
                System.out.println("Total Students : " + rs.getInt("total"));
                // Using printf to format the average to 2 decimal places
                System.out.printf("Average Marks  : %.2f\n", rs.getDouble("average"));
                System.out.println("Highest Marks  : " + rs.getDouble("highest"));
                System.out.println("Lowest Marks   : " + rs.getDouble("lowest"));
                System.out.println("---------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error calculating statistics: " + e.getMessage());
        }
    }
}
