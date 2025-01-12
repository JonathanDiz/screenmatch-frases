package com.jonathandiz.screen_match.controller;

import com.jonathandiz.screen_match.entity.MovieQuote;
import com.jonathandiz.screen_match.service.MovieQuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RequestMapping("/movie-quotes")
@RestControllerAdvice 
public class MovieQuoteController {

    @Autowired
    private MovieQuoteService service;

    @GetMapping("/random")
    public MovieQuote getRandomQuote() {
        return service.getRandomQuote();
    }
}
