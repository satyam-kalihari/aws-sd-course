package com.example;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

// import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DatabaseHandler {
    
    private final String urlString = "jdbc:mysql://localhost:3306/library_db";
    private final String user = "root";
    private final String password = "20017705m@Mys";

    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(urlString, user, password);
    }

    public ObservableList<Book> getAllBookData() throws SQLException {
        ObservableList<Book> bookData = FXCollections.observableArrayList();
        String query = "SELECT * FROM book";

        try(Connection conn = getConnection()){
            java.sql.Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {
                String bookName = result.getString("book_name");
                String authorName = result.getString("author_name");
                String issuedBy = result.getString("issued_by");
                Date issuedDate = result.getDate("issued_date");

                bookData.add(new Book(bookName, authorName, issuedBy, issuedDate));
            }

        }catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return bookData;
    }
}
