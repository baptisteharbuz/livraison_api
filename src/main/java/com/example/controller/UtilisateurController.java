package com.example.controller;

import com.example.models.UtilisateurModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.services.UtilisateurService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {
    
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping
    public ResponseEntity<String> getUtilisateurs() {
        try {
            String json = objectMapper.writeValueAsString(utilisateurService.getAll());
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            return ResponseEntity.ok().headers(headers).body(json);
        } catch (Exception e) {
            return ResponseEntity.ok(e.toString());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getUtilisateurById(@PathVariable int id) {
        try {
            String json = objectMapper.writeValueAsString(utilisateurService.getById(id));
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            return ResponseEntity.ok().headers(headers).body(json);
        } catch (Exception e) {
            return ResponseEntity.ok(e.toString());
        }
    }

    @PostMapping
    public ResponseEntity<String> createUtilisateur(@RequestBody UtilisateurModel utilisateur) {
        try {
            utilisateurService.save(utilisateur);
            return ResponseEntity.ok("Utilisateur créé avec succès");
        } catch (Exception e) {
            return ResponseEntity.ok(e.toString());
        }
    }
}
