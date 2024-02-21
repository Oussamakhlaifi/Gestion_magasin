package com.example.gestionstock;

import com.bdd.IdentifyService;
import com.bdd.Methode;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.swing.JOptionPane;



import java.io.IOException;
import java.sql.Date;
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
    private Button Commende;
    @FXML
    private Button Statistique;
    @FXML
    private Button deconnexion;
    @FXML
    private Button Home;
    @FXML
    private Button Ajouter_Fournisseur;
    @FXML
    private TextField NameF;
    @FXML
    private TextField Type_Product;
    @FXML
    private TextField ID_product;
    @FXML
    private Button product;
    @FXML
    private TextField name_p;
    @FXML
    private TextField quantity_;
    @FXML
    private TextField price_b ;
    @FXML
    private DatePicker date;
    @FXML
    private Button BouttonB;
    @FXML
    private TextField NameProduct;
    @FXML
    private TextField TypeProduct;
    @FXML
    private TextField QuantityProduct;
    @FXML
    private Button BPro;
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("register.fxml"));
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
    @FXML
    protected void AddFournisseur() {
        try {
            // Charger le fichier FXML de la page "register.fxml"
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Liste_Fournisseur.fxml"));
            Parent root = loader.load();

            // Changer le contenu de la scène principale avec la nouvelle page
            Scene scene = Fournisseur.getScene();
            scene.setRoot(root);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error loading Register page: " + e.getMessage());
        }
    }
    @FXML
    protected void AddCommende() {
        try {
            // Charger le fichier FXML de la page "register.fxml"
            FXMLLoader loader = new FXMLLoader(getClass().getResource("commende.fxml"));
            Parent root = loader.load();

            // Changer le contenu de la scène principale avec la nouvelle page
            Scene scene = Commende.getScene();
            scene.setRoot(root);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error loading Register page: " + e.getMessage());
        }
    }


        // Méthode de déconnexion
        public void logout() {
            // Code pour effectuer la déconnexion
            // Par exemple, vous pouvez réinitialiser les données de session, fermer les connexions de base de données, etc.

            // Affichage d'un message de déconnexion (à titre d'exemple)
            System.out.println("Déconnexion réussie.");

            // Fermeture de l'application JavaFX (vous pouvez également naviguer vers une autre fenêtre ou effectuer d'autres actions)
            Platform.exit();
        }
    @FXML
    protected void Home() {
        try {
            // Charger le fichier FXML de la page "register.fxml"
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Parent root = loader.load();

            // Changer le contenu de la scène principale avec la nouvelle page
            Scene scene = Home.getScene();
            scene.setRoot(root);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error loading Register page: " + e.getMessage());
        }

    }
    @FXML
    protected void Statisque() {
        try {
            // Charger le fichier FXML de la page "register.fxml"
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Statistique.fxml"));
            Parent root = loader.load();

            // Changer le contenu de la scène principale avec la nouvelle page
            Scene scene = Statistique.getScene();
            scene.setRoot(root);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error loading Register page: " + e.getMessage());
        }

    }
    @FXML
    protected void Fournisseur (){
        // Récupérer les valeurs des champs de texte
        String supplierName = NameF.getText();
        String productType = Type_Product.getText();

        // Convertir l'ID du produit en entier
        String productID = ID_product.getText();

        // Créer une instance de la classe d'insertion de fournisseur
        // Créer une instance de la classe Methode
        Methode methode = new Methode();

// Appeler la méthode insertFournisseur sur l'instance de la classe Methode
        if (methode.insertFournisseur(supplierName, productType, productID)) {
            JOptionPane.showMessageDialog(null, "L'insertion a réussi", "Succès", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "L'insertion a échoué", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
    @FXML
    protected void AddProduct() {
        try {
            // Charger le fichier FXML de la page "register.fxml"
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Product.fxml"));
            Parent root = loader.load();

            // Changer le contenu de la scène principale avec la nouvelle page
            Scene scene = product.getScene();
            scene.setRoot(root);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error loading Register page: " + e.getMessage());
        }
    }
    @FXML
    protected void Bilan() {
        // Récupérer les valeurs des champs de texte
        String name_pp = name_p.getText();
        String quantityText = quantity_.getText(); // Obtenez le texte du champ TextField
        int quantity = Integer.parseInt(quantityText);
        BigDecimal price_bb = new BigDecimal(price_b.getText());
        LocalDate selectedDate = date.getValue();

// Convertissez-la en un objet Date
        Date date_ = Date.valueOf(selectedDate);// Convertir en entier avec Integer.parseInt()

        // Créer une instance de la classe Methode
        Methode methode = new Methode();

        // Appeler la méthode insertBilant sur l'instance de la classe Methode
        if (methode.insertBilant(name_pp, quantity, price_bb, date_)) {
            JOptionPane.showMessageDialog(null, "L'insertion a réussi", "Succès", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "L'insertion a échoué", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

}


