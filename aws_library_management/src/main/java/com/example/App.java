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

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        URL fxmlLocation = getClass().getResource("/mainScreen.fxml"); 

        if (fxmlLocation == null) {
            // This will print an error if the FXML file isn't found, which is helpful for debugging
            System.err.println("Error: mainScreen.fxml not found at /mainScreen.fxml. Please check its location in the resources folder.");
            throw new IOException("Failed to load FXML file: mainScreen.fxml not found.");
        }
        
        FXMLLoader loader =  new FXMLLoader(fxmlLocation);
        Parent root = loader.load();
        Scene scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}