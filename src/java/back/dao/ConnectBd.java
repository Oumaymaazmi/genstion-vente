/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back.dao;

import static java.lang.Character.UnicodeBlock.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author a
 */
public class ConnectBd {

    static Connection con;

    public static Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/gestiondevente", "root", "");

            System.out.println("khaltd");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return con;
    }

    public static void main(String[] args) {
        ConnectBd.connect();

    }
}
