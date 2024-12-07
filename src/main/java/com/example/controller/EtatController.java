package com.example.controller;

import com.example.models.EtatModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.services.EtatService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/api/etats")
public class EtatController {
    
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EtatService etatService;

    @GetMapping
    public ResponseEntity<String> getEtats() {
        try {
            String json = objectMapper.writeValueAsString(etatService.getAll());
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            return ResponseEntity.ok().headers(headers).body(json);
        } catch (Exception e) {
            return ResponseEntity.ok(e.toString());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getEtatById(@PathVariable int id) {
        try {
            String json = objectMapper.writeValueAsString(etatService.getById(id));
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            return ResponseEntity.ok().headers(headers).body(json);
        } catch (Exception e) {
            return ResponseEntity.ok(e.toString());
        }
    }
}
