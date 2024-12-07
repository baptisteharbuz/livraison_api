package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.models.LivreurModel;
import com.example.models.LivraisonLivreurModel;
import com.example.models.LivraisonModel;
import com.example.wrappers.LivraisonWrapper;

@Service
public class LivraisonService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private LivraisonWrapper livraisonWrapper;

    public List<LivraisonModel> getAll() {
        String sql = "SELECT * FROM livraison;";
        return jdbcTemplate.query(sql, livraisonWrapper);
    }

    public LivraisonModel getById(int id) {
        String sql = "SELECT * FROM livraison WHERE id_livraison = ?;";
        return jdbcTemplate.queryForObject(sql, livraisonWrapper, id);
    }

    public void save(LivraisonModel livraison) {
        String sql = "INSERT INTO livraison (adresse_de_depart, destination, details_du_colis, fk_etat) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, livraison.getAdresse_de_depart(), livraison.getDestination(), livraison.getDetails_du_colis(), livraison.getFk_etat());
    }
}