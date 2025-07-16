package com.example;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.sql.Date;;

public class Book {
    private IntegerProperty bookId;
    private StringProperty bookName;
    private StringProperty authorName;
    private StringProperty user;
    private ObjectProperty<Date> issuedDate;
    private ObjectProperty<Date> duedDate;
    private StringProperty returned;
    private IntegerProperty paid;

    public Book(IntegerProperty bookId, StringProperty bookName, StringProperty authorName, StringProperty user,
            ObjectProperty<Date> issuedDate, ObjectProperty<Date> duedDate, StringProperty returned,
            IntegerProperty paid) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.user = user;
        this.issuedDate = issuedDate;
        this.duedDate = duedDate;
        this.returned = returned;
        this.paid = paid;
    }

    public Book(int bookId, String bookName, String authorName, String user,
            Date issuedDate, Date dueDate,String returned, int paid ){
        this.bookId = new SimpleIntegerProperty(bookId);
        this.bookName = new SimpleStringProperty(bookName);
        this.authorName = new SimpleStringProperty(authorName);
        this.user = new SimpleStringProperty(user);
        this.issuedDate = new SimpleObjectProperty<Date>(issuedDate);
        this.duedDate = new SimpleObjectProperty<Date>(dueDate);
        this.returned = new SimpleStringProperty(returned);
        this.paid = new SimpleIntegerProperty(paid);
    }

    public int getBookId(){
        return bookId.get();
    }
    public String getBookName(){
        return bookName.get();
    }
    public String getAuthorName(){
        return authorName.get();
    }
    public String getUser(){
        return user.get();
    }
    public Date getIssuedDate(){
        return issuedDate.get();
    }
    public Date getDueDate(){
        return duedDate.get();
    }
    public String getReturned(){
        return returned.get();
    }
    public int getPaid(){
        return paid.get();
    }

    public IntegerProperty bookIdProperty(){
        return bookId;
    }
    public StringProperty bookNameProperty(){
        return bookName;
    }
    public StringProperty authorNameProperty(){
        return authorName;
    }public StringProperty userProperty(){
        return user;
    }
    public ObjectProperty<Date> issuedDateProperty(){
        return issuedDate;
    }
    public ObjectProperty<Date> dueDateProperty(){
        return duedDate;
    }
    public StringProperty returnedProperty(){
        return returned;
    }
    public IntegerProperty paidProperty(){
        return paid;
    }
}
