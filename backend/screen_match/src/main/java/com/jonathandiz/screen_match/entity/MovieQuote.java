package com.jonathandiz.screen_match.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MovieQuote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String quote;
    private String movie;

    // Constructor
    public MovieQuote() {}

    public MovieQuote(String quote, String movie) {
        this.quote = quote;
        this.movie = movie;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getQuote() {
        return quote;
    }
    
    public void setQuote(String quote) {
        this.quote = quote;
    }
    
    public String getMovie() {
        return movie;
    }
    
    public void setMovie(String movie) {
        this.movie = movie;
    }
}
