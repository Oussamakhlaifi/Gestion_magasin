package com.example.gestionstock;

import com.bdd.IdentifyService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;


import java.io.IOException;
import java.util.EventObject;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button connexion;
    @FXML
    private Button register;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    private Button Fournisseur;


@FXML
protected void ident() {
    String enteredUsername = username.getText();
    String enteredPassword = password.getText();

    IdentifyService identify = new IdentifyService();

    if (identify.authenticate(enteredUsername, enteredPassword)) {
        System.out.println("Connexion réussie !");

        try {
            // Charger la deuxième page à partir du fichier FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Parent root = loader.load();

            // Accéder à la scène à partir du nœud source du bouton
            Scene scene = connexion.getScene();

            // Changer le contenu de la racine avec la deuxième page
            scene.setRoot(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        System.out.println("Échec de la connexion. Vérifiez votre nom d'utilisateur et votre mot de passe.");
    }
}
@FXML
protected void AddRegister() {
    try {
        // Charger le fichier FXML de la page "register.fxml"
        FXMLLoader loader = new FXMLLoader(getClass().getResource("com/example.gestionstock.register.fxml"));
        Parent root = loader.load();

        // Changer le contenu de la scène principale avec la nouvelle page
        Scene scene = register.getScene();
        scene.setRoot(root);

    } catch (IOException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
        System.err.println("Error loading Register page: " + e.getMessage());
    }
}
}
