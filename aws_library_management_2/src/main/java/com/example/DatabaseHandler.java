package com.example;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DatabaseHandler {
    private final String urlString = "jdbc:mysql://localhost:3306/library_db";
    private final String user = "root";
    private final String password = "20017705m@Mys";

    public Connection connectToDatabase() throws SQLException{
        return DriverManager.getConnection(urlString, user, password);
    }

    public ObservableList<Book> getAllBooks() throws SQLException{
        ObservableList<Book> bookData = FXCollections.observableArrayList();
        String query = "SELECT * FROM Book;";

        try(Connection conn = connectToDatabase();) {

            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {
                int bookId = result.getInt("bookId");
                String bookName = result.getString("bookName");
                String authorName = result.getString("authorName");
                String user = result.getString("user");
                Date issuedDate = result.getDate("issuedDate");
                Date dueDate = result.getDate("issuedDate");
                String returned = result.getString("returned");
                int paid = result.getInt("paid");

                bookData.add(new Book(bookId, bookName, authorName, user, issuedDate, dueDate, returned, paid));

            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.printf("Cannot connect to the database", bookData);
        }
        

        return bookData;
    }
}
