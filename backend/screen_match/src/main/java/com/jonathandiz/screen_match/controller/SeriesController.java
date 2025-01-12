package com.jonathandiz.screen_match.controller;

import com.jonathandiz.screen_match.model.Frase;
import com.jonathandiz.screen_match.service.FraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/series")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class SeriesController {

    private final FraseService fraseService;
    
    @Autowired
    public SeriesController(FraseService fraseService) {
        this.fraseService = fraseService;
    }

    @GetMapping("/frases")
    public List<Frase> getFrases() {
        return fraseService.obtenerFrases();
    }
}
