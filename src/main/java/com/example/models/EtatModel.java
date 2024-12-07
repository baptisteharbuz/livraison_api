package com.example.models;

public class EtatModel {
    private int id_etat;
    private String label_etat;

    public EtatModel(int id_etat, String label_etat) {
        this.id_etat = id_etat;
        this.label_etat = label_etat;
    }

    public EtatModel() {
    }
    // Getters et Setters
    public int getid_etat() {
        return id_etat;
    }

    public void setid_etat(int id_etat) {
        this.id_etat = id_etat;
    }

    public String getLabelEtat() {
        return label_etat;
    }

    public void setLabelEtat(String mail) {
        this.label_etat = mail;
    }
}