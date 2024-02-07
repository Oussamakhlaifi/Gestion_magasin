package com.bdd;

import java.sql.*;

public class methode {
    public class insert_Fournisseur {
        private static final String JDBC_URL = "jdbc:mysql://localhost:3306/gestion_de_magasin";
        private static final String DB_USER = "root";
        private static final String DB_PASSWORD = "";

        public boolean authenticate(String enteredUsername, String enteredPassword) {
            String query = "INSERT INTO table VALUES ('valeur 1', 'valeur 2', ...) ";

            try (
                    Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
                    PreparedStatement preparedStatement = connection.prepareStatement(query)
            ) {
                preparedStatement.setString(1, enteredUsername);
                preparedStatement.setString(2, enteredPassword);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return resultSet.next(); // true if a match is found, otherwise false
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }}
}
