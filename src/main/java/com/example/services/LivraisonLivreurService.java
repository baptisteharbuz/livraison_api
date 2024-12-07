package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.models.LivraisonLivreurModel;
import com.example.wrappers.LivraisonLivreurWrapper;

@Service
public class LivraisonLivreurService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private LivraisonLivreurWrapper livraisonLivreurWrapper;

    @Autowired
    private LivreurService livreurService;

    public List<LivraisonLivreurModel> getAll() {
        String sql = "SELECT * FROM livraison_livreur;";
        return jdbcTemplate.query(sql, livraisonLivreurWrapper);
    }

    public LivraisonLivreurModel getById(int id) {
        String sql = "SELECT * FROM livraison_livreur WHERE id_livraison_livreur = ?;";
        return jdbcTemplate.queryForObject(sql, livraisonLivreurWrapper, id);
    }

    public void save(LivraisonLivreurModel livraisonLivreur) {
        String sql = "INSERT INTO livraison_livreur (fk_livraison, fk_livreur) VALUES (?, ?)";
        jdbcTemplate.update(sql,
            livraisonLivreur.getFk_livraison(),
            livraisonLivreur.getFk_livreur()
        );
        livreurService.updateDisponibility(livraisonLivreur.getFk_livreur(), false);
    }
}