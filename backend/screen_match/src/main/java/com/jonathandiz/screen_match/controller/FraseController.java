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

    // Asegúrate de que el endpoint para obtener una frase aleatoria esté definido correctamente
    @GetMapping("/random")
    public ResponseEntity<Frase> obtenerFraseAleatoria(){
        Frase frase = fraseService.obtenerFraseAleatoria();
        if (frase != null) {
            return ResponseEntity.ok(frase);
        } else {
            return ResponseEntity.noContent().build(); // Manejar el caso cuando no hay frases disponibles
        }
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
    public ResponseEntity<Frase> createFrase(@RequestBody Frase frase) {
        Frase createdFrase = fraseService.saveFrase(frase);
        return ResponseEntity.ok(createdFrase);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Frase> updateFrase(@PathVariable Long id, @RequestBody Frase frase) {
        Optional<Frase> updatedFrase = fraseService.updateFrase(id, frase);
        return updatedFrase.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFrase(@PathVariable Long id) {
        fraseService.deleteFrase(id);
        return ResponseEntity.noContent().build();
    }
}
