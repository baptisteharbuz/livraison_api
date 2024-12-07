package com.example.wrappers;

import com.example.models.LivraisonLivreurModel;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class LivraisonLivreurWrapper implements RowMapper<LivraisonLivreurModel> {

    @Override
    public LivraisonLivreurModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new LivraisonLivreurModel(
            rs.getInt("id_livraison_livreur"),
            rs.getInt("fk_livraison"),
            rs.getInt("fk_livreur")
        );
    }
}