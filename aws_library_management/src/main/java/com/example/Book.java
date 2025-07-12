package com.example;

import javafx.beans.property.StringProperty;

import java.sql.Date;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;


public class Book {
    private StringProperty bookName;
    private StringProperty authName;
    private StringProperty issuedBy;
    private ObjectProperty<Date> issuedDate;

    public Book(StringProperty bookName, StringProperty authName, StringProperty issuedBy, ObjectProperty<Date> issuedDate) {
        this.bookName = bookName;
        this.authName = authName;
        this.issuedBy = issuedBy;
        this.issuedDate = issuedDate;
    }

    public Book(String bookName, String authName, String issuedBy, Date issuedDate) {
        this.bookName = new SimpleStringProperty(bookName);
        this.authName = new SimpleStringProperty(authName);
        this.issuedBy = new SimpleStringProperty(issuedBy);
        this.issuedDate = new SimpleObjectProperty<Date>(issuedDate);
    }

    public String getbookName() {
        return bookName.get();
    }
    public String getauthName() {
        return authName.get();
    }
    public String getissuedBy() {
        return issuedBy.get();
    }
    public Date getissuedDate(){
        return issuedDate.get();
    }

    public StringProperty bookNameProperty() {
        return bookName;
    }

    public StringProperty authNameProperty() {
        return authName;
    }

    public StringProperty issuedByProperty() {
        return issuedBy;
    }

    public ObjectProperty<Date> issuedDateProperty() {
        return issuedDate;
    }

    
    
}
