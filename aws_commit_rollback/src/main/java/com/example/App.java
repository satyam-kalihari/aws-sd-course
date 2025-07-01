package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        // Get a database connection
        Connection conn = getDatabaseConnection();


        if (conn != null) {
            try {
                // Create products table if it doesn't exist
                createProductsTable(conn);


                // Insert sample data into the products table
                insertProductData(conn, 1, "Milk", "2024-10-20", 100);
                insertProductData(conn, 2, "Yogurt", "2024-11-19", 50);
                insertProductData(conn, 3, "Cheese", "2024-09-18", 30);


                // Call removeExpiredProduct for multiple products
                conn.setAutoCommit(false); // Start transaction


                removeExpiredProduct(conn, 3);  // Removing Cheese


                conn.commit();  // Commit transaction if all operations succeed
                System.out.println("Transaction committed successfully!");


            } catch (SQLException e) {
                try {
                    // Rollback the transaction if any error occurs
                    conn.rollback();
                    System.out.println("Transaction rolled back due to error: " + e.getMessage());
                } catch (SQLException rollbackEx) {
                    System.out.println("Failed to rollback: " + rollbackEx.getMessage());
                }
            } finally {
                try {
                    conn.close();  // Close the connection
                } catch (SQLException e) {
                    System.out.println("Failed to close connection: " + e.getMessage());
                }
            }
        } else {
            System.out.println("Failed to connect to the database.");
        }
    }

    // Method to establish a database connection
    // DONE
    private static Connection getDatabaseConnection() {
        String url = "jdbc:mysql://127.0.0.1:3306/chinook";
        String user = "root";
        String password = "20017705m@Mys";


        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            return null;
        }
    }

    // Method to create the 'products' table
    // DONE
    private static void createProductsTable(Connection conn) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS grocery_products ("
                                + "product_id INT PRIMARY KEY, "
                                + "product_name VARCHAR(50), "
                                + "expiry_date DATE, "
                                + "quantity INT)";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Table 'grocery_products' created or already exists.");
        }
    }

    // Method to insert product data into the 'products' table
    // DONE
    private static void insertProductData(Connection conn, int productId, String productName, String expiryDate, int quantity) throws SQLException {
        String insertSQL = "INSERT INTO grocery_products (product_id, product_name, expiry_date, quantity) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setInt(1, productId);
            pstmt.setString(2, productName);
            pstmt.setDate(3, java.sql.Date.valueOf(expiryDate));  // Expiry date format: "YYYY-MM-DD"
            pstmt.setInt(4, quantity);
            pstmt.executeUpdate();
            System.out.println("Product " + productName + " inserted successfully.");
        }
    }

    private static void removeExpiredProduct(Connection conn, int productId) throws SQLException {
    
        String deleteSQL = "DELETE FROM grocery_products WHERE product_id = ?";
          
        // TODO: Set the productId parameter in the PreparedStatement
        try(PreparedStatement pstmt = conn.prepareStatement(deleteSQL)){
            
            pstmt.setInt(1, productId);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected == 0) {
                throw new SQLException("No product found with product ID " + productId);
            }
   
            System.out.println("Product with product_id = " + productId + " removed successfully.");

        } catch (SQLException e) {
            // Exception handling: If an error occurs, print the message and rethrow the exception
            System.out.println("Error removing product with product_id = " + productId + ": " + e.getMessage());
            throw e;  // Rethrow the exception to be handled at a higher level (e.g., main method)
        }
    }
}
