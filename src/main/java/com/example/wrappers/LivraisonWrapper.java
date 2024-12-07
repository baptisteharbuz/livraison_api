package com.example.wrappers;

import com.example.models.LivraisonModel;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class LivraisonWrapper implements RowMapper<LivraisonModel> {

    @Override
    public LivraisonModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new LivraisonModel(
            rs.getInt("id_livraison"),
            rs.getString("adresse_de_depart"),
            rs.getString("destination"),
            rs.getString("details_du_colis"),
            rs.getTimestamp("date_creation"),
            rs.getInt("fk_etat")
        );
    }
}