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

import com.example.models.LivraisonModel;
import com.example.services.LivraisonService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/api/livraisons")
public class LivraisonController {
    
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private LivraisonService livraisonService;

    @GetMapping
    public ResponseEntity<String> getLivraisons() {
        try {
            String json = objectMapper.writeValueAsString(livraisonService.getAll());
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            return ResponseEntity.ok().headers(headers).body(json);
        } catch (Exception e) {
            return ResponseEntity.ok(e.toString());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getLivraisonById(@PathVariable int id) {
        try {
            String json = objectMapper.writeValueAsString(livraisonService.getById(id));
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            return ResponseEntity.ok().headers(headers).body(json);
        } catch (Exception e) {
            return ResponseEntity.ok(e.toString());
        }
    }

    @PostMapping
    public ResponseEntity<String> createLivraison(@RequestBody LivraisonModel livraison) {
        try {
            livraisonService.save(livraison);
            return ResponseEntity.ok("Livraison créée avec succès");
        } catch (Exception e) {
            return ResponseEntity.ok(e.toString());
        }
    }
}