/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back.dao;

import back.bean.Client;
import back.bean.Produit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a
 */
public class ProduitDao  {

    Connection connection;
    PreparedStatement preparedStatement;

    public List<Produit> findAll() {
        List<Produit> produits = new ArrayList<>();
        String sql = "SELECT * FROM produit";

        try {
            connection = ConnectBd.connect();

            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Produit p = new Produit();
                p.setId(resultSet.getLong(1));
                p.setCodebare(resultSet.getString(3));
                p.setLibelle(resultSet.getString(4));
                p.setPrix(resultSet.getDouble(2));
                produits.add(p);
            }
        } catch (Exception ex) {
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return produits;

    }
    
    
     public Produit findById(Long id) {
        String sql = "SELECT * FROM produit WHERE id="+id;

        try {
            connection = ConnectBd.connect();

            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Produit p = new Produit();
                p.setId(resultSet.getLong(1));
                p.setCodebare(resultSet.getString(3));
                p.setLibelle(resultSet.getString(4));
                p.setPrix(resultSet.getDouble(2));
               return p;
            }
        } catch (Exception ex) {
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }
 
}




