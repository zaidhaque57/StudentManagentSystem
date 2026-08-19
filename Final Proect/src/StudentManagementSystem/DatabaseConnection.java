package StudentManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/student_db";
    private static final String USER = "root";
    private static final String PASSWORD = "h@quezaid419";

    public static Connection getConnection()
        throws SQLException {
            return DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );
        }
}