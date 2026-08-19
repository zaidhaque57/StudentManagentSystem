import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String []args){

        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";

        String username = "root";
        String password = "h@quezaid419";

        try{
            Connection connection =
                    DriverManager.getConnection(
                            url,
                            username,
                            password
                    );
            System.out.println("Database connected Successfully!");
            connection.close();

        }catch (SQLException e) {
            System.out.println("Database connection failed.");

            e.printStackTrace();
        }
    }
}
