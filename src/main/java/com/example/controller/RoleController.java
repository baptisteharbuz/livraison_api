package com.example.controller;

import com.example.models.RoleModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.services.RoleService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/api/roles")
public class RoleController {
    
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<String> getRoles() {
        try {
            String json = objectMapper.writeValueAsString(roleService.getAll());
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            return ResponseEntity.ok().headers(headers).body(json);
        } catch (Exception e) {
            return ResponseEntity.ok(e.toString());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getRoleById(@PathVariable int id) {
        try {
            String json = objectMapper.writeValueAsString(roleService.getById(id));
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            return ResponseEntity.ok().headers(headers).body(json);
        } catch (Exception e) {
            return ResponseEntity.ok(e.toString());
        }
    }
}
