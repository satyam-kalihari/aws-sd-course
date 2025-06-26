import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public static void main(String[] args) {
    String url = "jdbc:mysql://127.0.0.1:3306/chinook";
// Replace with your MySQL username
    String user = "root";
// Replace with your MySQL password
    String password = "20017705m@Mys";


    try (Connection connection = DriverManager.getConnection(url, user, password)) {
        if (connection != null) {
            System.out.println("Connected to the Chinook database!");

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select Name from artist");

            while (rs.next()) {
                String artistName = rs.getString("Name");
                System.out.println("Artist: "+ artistName);
            }
            rs.close();
            stmt.close();
        }
    
    } catch (SQLException e) {
        System.out.println("Connection failed: " + e.getMessage());
    }
}