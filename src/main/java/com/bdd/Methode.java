package com.bdd;

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
}

