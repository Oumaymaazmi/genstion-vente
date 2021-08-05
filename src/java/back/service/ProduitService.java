/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back.service;

import back.dao.ProduitDao;
import back.bean.Produit;
import java.util.List;

/**
 *
 * @author a
 */
public class ProduitService {

    public ProduitDao produitDao = new ProduitDao();

    public Produit findById(Long id) {
        return produitDao.findById(id);
    }

    public List<Produit> findAll() {
        return produitDao.findAll();
    }

}
