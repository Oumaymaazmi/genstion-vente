/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back.dao;

import back.bean.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a
 */
public class ClientDao {

    Connection connection;
    PreparedStatement preparedStatement;

   

    public Client findByLogin(String username) {

        Client client = new Client();
        String sql = "SELECT * FROM client WHERE username='" + username + "'";

        try {
            connection = ConnectBd.connect();

            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                client.setId(resultSet.getLong(1));
                client.setUsername(resultSet.getString(2));
                client.setPassword(resultSet.getString(3));
                client.setNom(resultSet.getString(4));
                client.setPrenom(resultSet.getString(5));

                return client;
            }
        } catch (Exception ex) {
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

}
