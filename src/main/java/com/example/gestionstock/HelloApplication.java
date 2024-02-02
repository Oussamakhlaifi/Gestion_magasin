package com.example.gestionstock;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Charge la première page depuis le fichier FXML
        Parent root = FXMLLoader.load(getClass().getResource("gestionCommende.fxml"));

        // Crée une scène avec la première page
        Scene scene = new Scene(root, 600, 400);

        // Configure la scène sur la fenêtre principale
        primaryStage.setScene(scene);
        primaryStage.setTitle("Votre Application JavaFX");

        // Affiche la fenêtre principale
        primaryStage.show();
    }

    // Méthode pour charger et afficher la deuxième page
    public static void showSecondPage() throws Exception {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(root, 600, 400));
        secondStage.setTitle("Deuxième Page");
        secondStage.show();
    }
    public static void showthirdPage() throws Exception {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("register.fxml"));
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(root, 600, 400));
        secondStage.setTitle("Deuxième Page");
        secondStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}