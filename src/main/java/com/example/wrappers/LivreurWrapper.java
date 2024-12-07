package com.example.wrappers;

import com.example.models.LivreurModel;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class LivreurWrapper implements RowMapper<LivreurModel> {

    @Override
    public LivreurModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new LivreurModel(
            rs.getInt("id_livreur"),
            rs.getString("nom"),
            rs.getString("prenom"),
            rs.getBoolean("disponible")
        );
    }
}