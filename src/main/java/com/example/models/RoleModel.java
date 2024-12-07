package com.example.models;

public class RoleModel {
    private int id_role;
    private String label_role;

    public RoleModel(int id_role, String label_role) {
        this.id_role = id_role;
        this.label_role = label_role;
    }

    public RoleModel() {
    }
    
    public int getid_role() {
        return id_role;
    }

    public void setid_role(int id_role) {
        this.id_role = id_role;
    }

    public String getLabelEtat() {
        return label_role;
    }

    public void setLabelEtat(String mail) {
        this.label_role = mail;
    }
}