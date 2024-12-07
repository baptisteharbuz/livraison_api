package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AliasFor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.models.UtilisateurModel;
import com.example.wrappers.UtilisateurWrapper;

@Service
public class UtilisateurService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UtilisateurWrapper utilisateurWrapper;

     public List<UtilisateurModel> getAll() {
        String sql = "SELECT * FROM utilisateur;";
        return jdbcTemplate.query(sql, utilisateurWrapper);
    }

    public UtilisateurModel getById(int id) {
        String sql = "SELECT * FROM utilisateur WHERE id_utilisateur = ?;";
        return jdbcTemplate.queryForObject(sql, utilisateurWrapper, id);
    }

    public void save(UtilisateurModel utilisateur) {
        String sql = "INSERT INTO utilisateur (mail, password, fk_role) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, utilisateur.getMail(), utilisateur.getPassword(), utilisateur.getfk_role());
    }
}
