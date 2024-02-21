package com.bdd;

import java.math.BigDecimal;
import java.sql.*;

public class Methode {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/gestion_de_magasin";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public Boolean insertFournisseur(String supplierName, String productType, String productID) {
        String query = "INSERT INTO fournisseur (name, type_product, id_product) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, supplierName);
            preparedStatement.setString(2, productType);
            preparedStatement.setString(3, productID);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0; // True if insertion successful, otherwise false
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public Boolean insertBilant(String name_pp, int quantity, BigDecimal price_bb, Date date_) {
        // Vérifiez si name_p est null ou vide
        if (name_pp == null || name_pp.isEmpty()) {
            // Si name_p est null ou vide, vous pouvez gérer cette situation de manière appropriée
            // Par exemple, vous pouvez lever une exception, retourner false ou effectuer d'autres actions selon votre logique métier
            System.err.println("Le nom du produit est null ou vide.");
            return false; // Ou lancez une exception ou effectuez d'autres actions
        }

        String query = "INSERT INTO Bilan (name_product, quantity, price, date) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, name_pp);
            preparedStatement.setInt(2, quantity);
            preparedStatement.setBigDecimal(3, price_bb);
            preparedStatement.setDate(4, date_);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0; // True if insertion successful, otherwise false
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean insertProduct(int idPro,String namePro, int quantityPro, String TypePro) {
        String query = "INSERT INTO product (id_product,name_product, quantity, type_product) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(2, idPro);
            preparedStatement.setString(1, namePro);
            preparedStatement.setInt(2, quantityPro);
            preparedStatement.setString(3, TypePro);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0; // True if insertion successful, otherwise false
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

