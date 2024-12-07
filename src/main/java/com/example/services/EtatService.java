package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AliasFor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.models.EtatModel;
import com.example.wrappers.EtatWrapper;

@Service
public class EtatService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EtatWrapper etatWrapper;

     public List<EtatModel> getAll() {
        String sql = "SELECT * FROM etat;";
        return jdbcTemplate.query(sql, etatWrapper);
    }

    public EtatModel getById(int id) {
        String sql = "SELECT * FROM etat WHERE id_etat = ?;";
        return jdbcTemplate.queryForObject(sql, etatWrapper, id);
    }
}
