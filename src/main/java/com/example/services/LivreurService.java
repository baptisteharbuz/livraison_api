package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.models.LivreurModel;
import com.example.wrappers.LivreurWrapper;

@Service
public class LivreurService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private LivreurWrapper livreurWrapper;

    public List<LivreurModel> getAll() {
        String sql = "SELECT * FROM livreur;";
        return jdbcTemplate.query(sql, livreurWrapper);
    }

    public LivreurModel getById(int id) {
        String sql = "SELECT * FROM livreur WHERE id_livreur = ?;";
        return jdbcTemplate.queryForObject(sql, livreurWrapper, id);
    }

    public void save(LivreurModel livreur) {
        String sql = "INSERT INTO livreur (nom, prenom, disponible) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, livreur.getNom(), livreur.getPrenom(), livreur.getDisponible());
    }

    public void updateDisponibility(int id, boolean disponible) {
        String sql = "UPDATE livreur SET disponible = ? WHERE id_livreur = ?";
        jdbcTemplate.update(sql, disponible, id);
    }
}
