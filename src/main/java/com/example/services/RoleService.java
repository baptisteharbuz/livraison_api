package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.models.RoleModel;
import com.example.wrappers.RoleWrapper;

@Service
public class RoleService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RoleWrapper roleWrapper;

     public List<RoleModel> getAll() {
        String sql = "SELECT * FROM role;";
        return jdbcTemplate.query(sql, roleWrapper);
    }

    public RoleModel getById(int id) {
        String sql = "SELECT * FROM role WHERE id_role = ?;";
        return jdbcTemplate.queryForObject(sql, roleWrapper, id);
    }
}
