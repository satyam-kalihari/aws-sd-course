package com.example;

import java.sql.Date;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController extends DatabaseHandler {

    @FXML
    private TableColumn<Book, String> authorName;

    @FXML
    private TableColumn<Book, String> bookName;

    @FXML
    private TableView<Book> bookTable;

    @FXML
    private TableColumn<Book, String> issuedBy;

    @FXML
    private TableColumn<Book, Date> issuedDate;

    @FXML
    private TextField searchText;

    @FXML
    public void initialize() throws SQLException{
        bookName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        authorName.setCellValueFactory(new PropertyValueFactory<>("authName"));
        issuedBy.setCellValueFactory(new PropertyValueFactory<>("issuedBy"));
        issuedDate.setCellValueFactory(new PropertyValueFactory<>("issuedDate"));

        bookTable.setItems(getAllBookData());
    }

}
