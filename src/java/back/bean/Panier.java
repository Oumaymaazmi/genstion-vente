/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back.bean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a
 */
public class Panier {

    public long id;
    public String adresseLivraison;
    private double totale;
    private List<ProduitPanier> produitPaniers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAdresseLivraison() {
        return adresseLivraison;
    }

    public void setAdresseLivraison(String adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    public double getTotale() {
        return totale;
    }

    public void setTotale(double totale) {
        this.totale = totale;
    }

    public List<ProduitPanier> getProduitPaniers() {
        if(produitPaniers==null){
            produitPaniers= new ArrayList<>();
        }
        return produitPaniers;
    }

    public void setProduitPaniers(List<ProduitPanier> produitPaniers) {
        this.produitPaniers = produitPaniers;
    }

    @Override
    public String toString() {
        return "Panier{" + "id=" + id + ", adresseLivraison=" + adresseLivraison + ", totale=" + totale + ", produitPaniers=" + produitPaniers + '}';
    }
    
    

}
