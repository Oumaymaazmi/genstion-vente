/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back.dao;

import back.bean.ProduitPanier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a
 */
public class ProduitPanierDao {

    Connection connection;
    PreparedStatement preparedStatement;

    public int save(ProduitPanier produitPanier) {
        try {
            String sql = "INSERT INTO produitPanier VALUES("+produitPanier.getId()+","+produitPanier.getProduit().getId()+","+produitPanier.getPanier().getId()+","+produitPanier.getPrix()+","+produitPanier.getQte()+")";
            connection = ConnectBd.connect();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(ProduitPanierDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }
     
    public int countAll() {
        String sql = "SELECT * FROM produitpanier";
        Connection connection;
        int cmp = 0;
        try {
            connection = ConnectBd.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cmp++;
            }
        } catch (Exception ex) {
        }

        return cmp;
    }
}
