package StudentDatabaseSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final  String url = "jdbc:mysql://127.0.0.1:3306/student_db?createDatabaseIfNotExist=true";
    private static final String username = "root";
    private static final String password = "h@quezaid419";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public static void intializeDatabase() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS students (" +
                "id INT PRIMARY KEY ,"+
                "name VARCHAR(100) NOT NULL,"+
                "age INT NOT NULL,"+
                "course VARCHAR(50),"+
                "marks DOUBLE NOT NULL)";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("[Database Connected & Verified]");
        } catch (SQLException e) {
            System.out.println("Failed to initialize database. Is MySQL running?");
            e.printStackTrace();
        }
    }
}
