/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back.bean;

/**
 *
 * @author a
 */
public class ProduitPanier {
    private long id;
    private Produit produit;
    private double prix;
    private double qte;
    private Panier panier;

    public ProduitPanier() {
    }

    
    public ProduitPanier(Produit produit) {
        this.produit = produit;
        this.qte=1D;
        this.prix=produit.getPrix();
    }

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getQte() {
        return qte;
    }

    public void setQte(double qte) {
        this.qte = qte;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    @Override
    public String toString() {
        return "ProduitPanier{" + "id=" + id + ", produit=" + produit + ", prix=" + prix + ", qte=" + qte + '}';
    }
    
    
    
}
