package com.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ajouter {  public void createCommand(int idFournisseur, String dateCommande, int idCommande) throws SQLException {
    Connection conn = null ;
    PreparedStatement stmt = null;

    try {
        conn = DriverManager.getConnection("jdbc:mysql://localhost/maven","root","");
        String query = "INSERT INTO commande  (id_fournisseur,id_commande,date_Commende) VALUES(?,?,?)";
        stmt = conn.prepareStatement(query);
        stmt.setInt(1,idFournisseur);
        stmt.setInt(2,idCommande);
        stmt.setString(3,dateCommande);
        stmt.execute();

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    // Code pour créer une nouvelle commande
}
}
