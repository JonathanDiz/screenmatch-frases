package com.jonathandiz.screen_match.service;

import com.jonathandiz.screen_match.model.Frase;
import com.jonathandiz.screen_match.repository.FraseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FraseService {

    private final FraseRepository fraseRepository;

    @Autowired
    public FraseService(FraseRepository fraseRepository) {
        this.fraseRepository = fraseRepository;
    }

    // Método para obtener todas las frases
    public List<Frase> obtenerFrases() {
        return fraseRepository.findAll();
    }
    
    // Método para obtener todas las frases (getAllFrases)
    public List<Frase> getAllFrases() {
        return fraseRepository.findAll();
    }

    public Optional<Frase> getFraseById(Long id) {
        return fraseRepository.findById(id);
    }

    public Frase saveFrase(Frase frase) {
        return fraseRepository.save(frase);
    }

    public void deleteFrase(Long id) {
        fraseRepository.deleteById(id);
    }

    public Frase updateFrase(Long id, Frase frase) {
        Optional<Frase> existingFrase = fraseRepository.findById(id);
        if (existingFrase.isPresent()) {
            Frase updatedFrase = existingFrase.get();
            updatedFrase.setTitulo(frase.getTitulo());
            updatedFrase.setFrase(frase.getFrase());
            updatedFrase.setPersonaje(frase.getPersonaje());
            updatedFrase.setPoster(frase.getPoster());
            return fraseRepository.save(updatedFrase);
        } else {
            return null; // Manejar el caso cuando la Frase con el ID dado no se encuentra
        }
    }
}
