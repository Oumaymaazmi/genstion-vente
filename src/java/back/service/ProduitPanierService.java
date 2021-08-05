/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back.service;

import back.bean.Panier;
import back.bean.ProduitPanier;
import back.dao.ConnectBd;
import back.dao.ProduitPanierDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author a
 */
public class ProduitPanierService {

    private ProduitPanierDao produitPanierDao = new ProduitPanierDao();

    public int save(Panier panier, List<ProduitPanier> produitPaniers) {
        if (produitPaniers == null || produitPaniers.isEmpty()) {
            return -1;
        }
        for (ProduitPanier produitPanier : produitPaniers) {
            produitPanier.setId(produitPanierDao.countAll() + 1);
            produitPanier.setPanier(panier);
            produitPanier.setProduit(produitPanier.getProduit());
            produitPanierDao.save(produitPanier);
        }
        return 1;
    }
   
}
