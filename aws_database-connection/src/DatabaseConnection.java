import java.sql.Connection;
// import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.MysqlDataSource;

public static void main(String[] args) {
    String url = "jdbc:mysql://127.0.0.1:3306/chinook";
// Replace with your MySQL username
    String user = "root";
// Replace with your MySQL password
    String password = "20017705m@Mys";
    
    MysqlDataSource mysqlDatabase = new MysqlDataSource();
    mysqlDatabase.setURL(url);
    mysqlDatabase.setUser(user);
    mysqlDatabase.setPassword(password);

    try (
        Connection connection = mysqlDatabase.getConnection();
        Statement sqlStatement = connection.createStatement();
        ResultSet result = sqlStatement.executeQuery("select Name from artist");
        ) {
        if (connection != null) {
            System.out.println("Connected to the Chinook database!");

            while (result.next()) {
                String artistName = result.getString("Name");
                System.out.println("Artist: "+ artistName);
            }
        }
    
    } catch (SQLException e) {
        System.out.println("Connection failed: " + e.getMessage());
    }
}