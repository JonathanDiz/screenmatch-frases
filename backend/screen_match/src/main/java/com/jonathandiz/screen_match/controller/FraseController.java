package com.jonathandiz.screen_match.controller;

import com.jonathandiz.screen_match.model.Frase;
import com.jonathandiz.screen_match.service.FraseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/frases")
public class FraseController {

    private final FraseService fraseService;

    @Autowired
    public FraseController(FraseService fraseService) {
        this.fraseService = fraseService;
    }

    @GetMapping
    public List<Frase> obtenerFrases() {
        return fraseService.getAllFrases();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Frase> getFraseById(@PathVariable Long id) {
        Optional<Frase> frase = fraseService.getFraseById(id);
        return frase.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Frase createFrase(@RequestBody Frase frase) {
        return fraseService.saveFrase(frase);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Frase> updateFrase(@PathVariable Long id, @RequestBody Frase frase) {
        Frase updatedFrase = fraseService.updateFrase(id, frase);
        return updatedFrase != null ? ResponseEntity.ok(updatedFrase) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFrase(@PathVariable Long id) {
        fraseService.deleteFrase(id);
        return ResponseEntity.noContent().build();
    }
}
