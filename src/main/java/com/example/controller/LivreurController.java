package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.models.LivreurModel;
import com.example.services.LivreurService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/api/livreurs")
public class LivreurController {
    
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private LivreurService livreurService;

    @GetMapping
    public ResponseEntity<String> getLivreurs() {
        try {
            String json = objectMapper.writeValueAsString(livreurService.getAll());
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            return ResponseEntity.ok().headers(headers).body(json);
        } catch (Exception e) {
            return ResponseEntity.ok(e.toString());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getLivreurById(@PathVariable int id) {
        try {
            String json = objectMapper.writeValueAsString(livreurService.getById(id));
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            return ResponseEntity.ok().headers(headers).body(json);
        } catch (Exception e) {
            return ResponseEntity.ok(e.toString());
        }
    }

    @PostMapping
    public ResponseEntity<String> createLivreur(@RequestBody LivreurModel livreur) {
        try {
            livreurService.save(livreur);
            return ResponseEntity.ok("Livreur créé avec succès");
        } catch (Exception e) {
            return ResponseEntity.ok(e.toString());
        }
    }
}
