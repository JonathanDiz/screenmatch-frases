package com.jonathandiz.screen_match.service;

import com.jonathandiz.screen_match.entity.MovieQuote;
import com.jonathandiz.screen_match.repository.MovieQuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class MovieQuoteService {

    @Autowired
    private MovieQuoteRepository repository;

    public List<MovieQuote> getAllQuotes() {
        return repository.findAll();
    }
    public MovieQuote getRandomQuote() {
       List<MovieQuote> quotes = repository.findAll();
       Random random = new Random();
       return quotes.get(random.nextInt(quotes.size()));
    }
}