package com.example.wrappers;

import com.example.models.RoleModel;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RoleWrapper implements RowMapper<RoleModel> {

    @Override
    public RoleModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new RoleModel(
            rs.getInt("id_Role"),
            rs.getString("label_Role")
        );
    }
}