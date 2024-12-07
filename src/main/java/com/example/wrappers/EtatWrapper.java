package com.example.wrappers;

import com.example.models.EtatModel;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EtatWrapper implements RowMapper<EtatModel> {

    @Override
    public EtatModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new EtatModel(
            rs.getInt("id_etat"),
            rs.getString("label_etat")
        );
    }
}