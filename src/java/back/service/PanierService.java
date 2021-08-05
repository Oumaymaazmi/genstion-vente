/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back.service;

import back.bean.Panier;
import back.bean.Produit;
import back.bean.ProduitPanier;
import back.dao.PanierDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a
 */
public class PanierService {

    private PanierDao panierDao = new PanierDao();
    private ProduitService produitService = new ProduitService();

    private ProduitPanierService produitPanierService = new ProduitPanierService();

    public int save(Panier panier) {
        panier.setId(panierDao.countAll() + 1);
        panierDao.save(panier);
        produitPanierService.save(panier, panier.getProduitPaniers());
        return 1;

    }

     public int add(Long idProduitPanier, Panier panier) {
        Produit produit = produitService.findById(idProduitPanier);
        ProduitPanier produitPanier= new ProduitPanier(produit);
        return add(produitPanier, panier);
     }
    public int add(ProduitPanier produitPanier, Panier panier) {
        if (panier.getProduitPaniers() == null || panier.getProduitPaniers().isEmpty()) {
            panier.setProduitPaniers(new ArrayList<>());
        }
        if (produitExist(produitPanier.getProduit(), panier)) {
            return -1;
        } else {
            panier.getProduitPaniers().add(clone(produitPanier));
            calculerTotal(panier);
            return 1;
        }

    }

    private boolean produitExist(Produit produit, Panier panier) {
        List<ProduitPanier> produitPaniers = panier.getProduitPaniers();
        for (ProduitPanier produitPanier : produitPaniers) {
            if (produitPanier.getProduit().equals(produit)) {
                return true;
            }
        }
        return false;
    }

    private ProduitPanier clone(ProduitPanier produitPanier) {
        ProduitPanier myCLone = new ProduitPanier();
        myCLone.setProduit(produitPanier.getProduit());
        myCLone.setQte(produitPanier.getQte());
        myCLone.setPrix(produitPanier.getPrix());

        return myCLone;
    }

    private void calculerTotal(Panier panier) {
        List<ProduitPanier> produitPaniers = panier.getProduitPaniers();
        double total = 0D;
        for (ProduitPanier produitPanier : produitPaniers) {
            total += produitPanier.getPrix() * produitPanier.getQte();
        }
        panier.setTotale(total);
    }
}
