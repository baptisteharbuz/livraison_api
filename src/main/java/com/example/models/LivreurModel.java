package com.example.models;

public class LivreurModel {
    private int id_livreur;
    private String nom;
    private String prenom;
    private Boolean disponible = true;

    public LivreurModel(int id_livreur, String nom, String prenom, Boolean disponible) {
        this.id_livreur = id_livreur;
        this.nom = nom;
        this.prenom = prenom;
        this.disponible = disponible;
    }
    
    public LivreurModel() {
    }
    // Getters et Setters
    public int getid_livreur() {
        return id_livreur;
    }

    public void setid_livreur(int id_livreur) {
        this.id_livreur = id_livreur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
    
}