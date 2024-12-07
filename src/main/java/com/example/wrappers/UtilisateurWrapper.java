package com.example.wrappers;

import com.example.models.UtilisateurModel;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UtilisateurWrapper implements RowMapper<UtilisateurModel> {

    @Override
    public UtilisateurModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UtilisateurModel(
            rs.getInt("id_utilisateur"),
            rs.getString("mail"),
            rs.getString("password"),
            rs.getTimestamp("date_creation"),
            rs.getInt("fk_role")
        );
    }
}