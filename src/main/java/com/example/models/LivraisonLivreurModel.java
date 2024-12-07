package com.example.models;

public class LivraisonLivreurModel {
    private int id_livraison_livreur;
    private int fk_livreur;
    private int fk_livraison;

    public LivraisonLivreurModel(int id_livraison_livreur, int fk_livreur, int fk_livraison) {
        this.id_livraison_livreur = id_livraison_livreur;
        this.fk_livreur = fk_livreur;
        this.fk_livraison = fk_livraison;
    }

    public LivraisonLivreurModel() {
    }

    public int getId_livraison_livreur() {
        return id_livraison_livreur;
    }

    public void setId_livraison_livreur(int id_livraison_livreur) {
        this.id_livraison_livreur = id_livraison_livreur;
    }

    public int getFk_livreur() {
        return fk_livreur;
    }

    public void setFk_livreur(int fk_livreur) {
        this.fk_livreur = fk_livreur;
    }

    public int getFk_livraison() {
        return fk_livraison;
    }

    public void setFk_livraison(int fk_livraison) {
        this.fk_livraison = fk_livraison;
    }
}