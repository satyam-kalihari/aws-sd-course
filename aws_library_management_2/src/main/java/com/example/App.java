package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(@SuppressWarnings("exports") Stage stage) throws IOException {
        URL fxmlLocation = getClass().getResource("/bookTable.fxml");

        if (fxmlLocation == null) {
            System.err.println("Error: MainScreen.fxml not found");
            throw new IOException("Failed to load FXML file: mainScreen.fxml not found.");
        }

        FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Library Management");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    
}