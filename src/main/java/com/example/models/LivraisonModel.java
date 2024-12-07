package com.example.models;

import java.sql.Timestamp;

public class LivraisonModel {
    private int id_livraison;
    private String adresse_de_depart;
    private String destination;
    private String details_du_colis;
    private Timestamp date_creation;
    private int fk_etat;

    public LivraisonModel(int id_livraison, String adresse_de_depart, String destination, String details_du_colis,
                          Timestamp date_creation, int fk_etat) {
        this.id_livraison = id_livraison;
        this.adresse_de_depart = adresse_de_depart;
        this.destination = destination;
        this.details_du_colis = details_du_colis;
        this.date_creation = date_creation;
        this.fk_etat = fk_etat;
    }

    public LivraisonModel() {
    }

    // Getters et Setters
    public int getId_livraison() {
        return id_livraison;
    }

    public void setId_livraison(int id_livraison) {
        this.id_livraison = id_livraison;
    }

    public String getAdresse_de_depart() {
        return adresse_de_depart;
    }

    public void setAdresse_de_depart(String adresse_de_depart) {
        this.adresse_de_depart = adresse_de_depart;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDetails_du_colis() {
        return details_du_colis;
    }

    public void setDetails_du_colis(String details_du_colis) {
        this.details_du_colis = details_du_colis;
    }

    public Timestamp getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Timestamp date_creation) {
        this.date_creation = date_creation;
    }

    public int getFk_etat() {
        return fk_etat;
    }

    public void setFk_etat(int fk_etat) {
        this.fk_etat = fk_etat;
    }
}