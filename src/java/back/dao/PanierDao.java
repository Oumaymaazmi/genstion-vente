/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back.dao;

import back.bean.Panier;
import back.bean.Produit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a
 */
public class PanierDao {

    Connection connection;
    PreparedStatement preparedStatement;

    public int save(Panier panier) {
        try {
            String sql = "INSERT INTO panier(id,adresseLivraison, totale)VALUES(" + panier.getId()+",'"+panier.getAdresseLivraison()+"',"+panier.getTotale()+")";
            connection = ConnectBd.connect();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(PanierDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }

    public int countAll() {
        String sql = "SELECT * FROM produit";
        int cmp = 0;
        try {
            connection = ConnectBd.connect();
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cmp++;
            }
        } catch (Exception ex) {
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cmp;
    }
}
