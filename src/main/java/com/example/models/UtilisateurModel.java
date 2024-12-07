package com.example.models;

import java.sql.Timestamp;

public class UtilisateurModel {
    private int id_utilisateur;
    private String mail;
    private String password;
    private Timestamp date_creation;
    private int fk_role;

    public UtilisateurModel(int id_utilisateur, String mail, String password, Timestamp date_creation, int fk_role) {
        this.id_utilisateur = id_utilisateur;
        this.mail = mail;
        this.password = password;
        this.date_creation = date_creation;
        this.fk_role = fk_role;
    }

    public UtilisateurModel() {
    }
    // Getters et Setters
    public int getid_utilisateur() {
        return id_utilisateur;
    }

    public void setid_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getDateCreation() {
        return date_creation;
    }

    public void setDateCreation(Timestamp date_creation) {
        this.date_creation = date_creation;
    }

    public int getfk_role() {
        return fk_role;
    }

    public void setfk_role(int fk_role) {
        this.fk_role = fk_role;
    }
}