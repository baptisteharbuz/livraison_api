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

import com.example.models.LivraisonLivreurModel;
import com.example.services.LivraisonLivreurService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/api/livraisons_livreurs")
public class LivraisonLivreurController {
    
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private LivraisonLivreurService livraisonLivreurService;

    @GetMapping
    public ResponseEntity<String> getLivraisonsLivreurs() {
        try {
            String json = objectMapper.writeValueAsString(livraisonLivreurService.getAll());
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            return ResponseEntity.ok().headers(headers).body(json);
        } catch (Exception e) {
            return ResponseEntity.ok(e.toString());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getLivraisonLivreurById(@PathVariable int id) {
        try {
            String json = objectMapper.writeValueAsString(livraisonLivreurService.getById(id));
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            return ResponseEntity.ok().headers(headers).body(json);
        } catch (Exception e) {
            return ResponseEntity.ok(e.toString());
        }
    }

    @PostMapping
    public ResponseEntity<String> createLivraisonLivreur(@RequestBody LivraisonLivreurModel livraisonLivreur) {
        try {
            livraisonLivreurService.save(livraisonLivreur);
            return ResponseEntity.ok("Relation Livraison-Livreur créée avec succès");
        } catch (Exception e) {
            return ResponseEntity.ok(e.toString());
        }
    }
}
