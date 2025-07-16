package com.example;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import javafx.beans.binding.Bindings;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class mainSceen extends DatabaseHandler {

    @FXML
    private Button addBtn;

    @FXML
    private TextField amountTextArea;

    @FXML
    private TableColumn<Book, String> author;

    @FXML
    private TextField authorNameTextArea;

    @FXML
    private TableView<Book> bookData;

    @FXML
    private TableColumn<Book, Integer> bookId;

    @FXML
    private TableColumn<Book, String> bookName;

    @FXML
    private TextField bookNameTextArea;

    @FXML
    private Button deleteBtn;

    @FXML
    private TableColumn<Book, Date> dueDate;

    @FXML
    private TableColumn<Book, Date> issuedOn;

    @FXML
    private TableColumn<Book, Integer> paid;

    @FXML
    private Button readBtn;

    @FXML
    private TableColumn<Book, String> returned;

    @FXML
    private TextField returnedTextField;

    @FXML
    private TextField searchBox;

    @FXML
    private Button updateBtn;

    @FXML
    private TableColumn<Book, String> user;

    @FXML
    private TextField userNameTextArea;

    @FXML
    private DatePicker dueDateTextArea;

    @FXML
    private DatePicker issuedDateTextArea;

    @FXML
    public void initialize() throws SQLException{
        bookId.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        bookName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        author.setCellValueFactory(new PropertyValueFactory<>("authorName"));
        user.setCellValueFactory(new PropertyValueFactory<>("user"));
        issuedOn.setCellValueFactory(new PropertyValueFactory<>("issuedDate"));
        dueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        returned.setCellValueFactory(new PropertyValueFactory<>("returned"));
        paid.setCellValueFactory(new PropertyValueFactory<>("paid"));

        refreshTable();
    }

    public void refreshTable() throws SQLException{
        FilteredList<Book> filteredData = new FilteredList<>(getAllBooks(), p -> true);
        filteredData.predicateProperty().bind(Bindings.createObjectBinding(() -> {
            String searchText = searchBox.getText();

            if (searchText == null) {
                return book -> true;
            }

            String lowercaseSearchText = searchText.toLowerCase();
            return book -> book.getBookName().toLowerCase().contains(lowercaseSearchText);

        }, searchBox.textProperty()));

        bookData.setItems(filteredData);
    }

    @FXML
    void addData(ActionEvent event) throws SQLException {
        String bookName = bookNameTextArea.getText();
        String authorName = authorNameTextArea.getText();
        String user = userNameTextArea.getText();
        LocalDate issuedDate = issuedDateTextArea.getValue();
        LocalDate dueDate = dueDateTextArea.getValue();
        String returned = returnedTextField.getText();
        String paid = amountTextArea.getText();

        String query = "INSERT INTO Book(bookName, authorName, user, issuedDate, dueDate, returned, paid ) VALUES (?, ?, ?, ?, ?, ? ,?)";

        try(Connection conn = connectToDatabase()){
            PreparedStatement pstmt =conn.prepareStatement(query);

            pstmt.setString(1, bookName);
            pstmt.setString(2, authorName);
            pstmt.setString(3, user);
            pstmt.setDate(4, Date.valueOf(issuedDate));
            pstmt.setDate(5, Date.valueOf(dueDate));
            pstmt.setString(6, returned);
            pstmt.setInt(7, Integer.valueOf(paid));

            pstmt.executeUpdate();

            refreshTable();
        }catch(SQLException e){
            System.out.println();
        }

    }

    @FXML
    void deleteData(ActionEvent event) {
        try {
            Book selectedBook = bookData.getSelectionModel().getSelectedItem();

            String query = "DELETE FROM Book WHERE bookId = ?;";

            try(Connection conn = connectToDatabase()){
                PreparedStatement pstmt = conn.prepareStatement(query);

                pstmt.setInt(1, selectedBook.getBookId());

                int result = pstmt.executeUpdate();

                if (result == 1) {
                    System.out.println("Book deleted");
                }

                refreshTable();
            }catch(SQLException e){
                System.out.println(e.getNextException());
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void getData(ActionEvent event) {
        Book selectedBook = bookData.getSelectionModel().getSelectedItem();

        bookNameTextArea.setText(selectedBook.getBookName());
        authorNameTextArea.setText(selectedBook.getAuthorName());
        userNameTextArea.setText(selectedBook.getUser());
        issuedDateTextArea.setValue(selectedBook.getIssuedDate().toLocalDate());
        dueDateTextArea.setValue(selectedBook.getDueDate().toLocalDate());
        returnedTextField.setText(selectedBook.getReturned());
        // mainSceen.java, line 159
        amountTextArea.setText(String.valueOf(selectedBook.getPaid()));

    }

    @FXML
    void updateData(ActionEvent event) {

        Book selectedBook = bookData.getSelectionModel().getSelectedItem();

        String bookName = bookNameTextArea.getText();
        String authorName = authorNameTextArea.getText();
        String user = userNameTextArea.getText();
        LocalDate issuedDate = issuedDateTextArea.getValue();
        LocalDate dueDate = dueDateTextArea.getValue();
        String returned = returnedTextField.getText();
        String paid = amountTextArea.getText();

        String query = "UPDATE Book " + //
                        "SET " + //
                        "bookName = ?, " + //
                        "authorName = ?, " + //
                        "user = ?, " + //
                        "issuedDate = ?, " + //
                        "dueDate = ?, " + //
                        "returned = ?, " + //
                        "paid = ? " + //
                        "WHERE " + //
                        "bookId = ?;";
        
        if (selectedBook.getBookName() != null) {
            try(Connection conn = connectToDatabase()) {

            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, bookName);
            pstmt.setString(2, authorName);
            pstmt.setString(3, user);
            pstmt.setDate(4, Date.valueOf(issuedDate));
            pstmt.setDate(5, Date.valueOf(dueDate));
            pstmt.setString(6, returned);
            pstmt.setInt(7, Integer.valueOf(paid));
            pstmt.setInt(8, selectedBook.getBookId());

            int result = pstmt.executeUpdate();
            if (result == 1) {
                System.out.println("Updated successfully");
            }

            refreshTable();

        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        }

        
    }

}
