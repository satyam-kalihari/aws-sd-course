package com.example;

import java.sql.Date;
import java.sql.SQLException;

import javafx.beans.binding.Bindings;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    private TextField dueDateTextArea;

    @FXML
    private TextField issuedDateTextArea;

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
    public void initialize() throws SQLException{
        bookId.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        bookName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        author.setCellValueFactory(new PropertyValueFactory<>("authorName"));
        user.setCellValueFactory(new PropertyValueFactory<>("user"));
        issuedOn.setCellValueFactory(new PropertyValueFactory<>("issuedDate"));
        dueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        returned.setCellValueFactory(new PropertyValueFactory<>("returned"));
        paid.setCellValueFactory(new PropertyValueFactory<>("paid"));

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
    void addData(ActionEvent event) {

    }

    @FXML
    void deleteData(ActionEvent event) {

    }

    @FXML
    void getData(ActionEvent event) {

    }

    @FXML
    void updateData(ActionEvent event) {

    }

}
