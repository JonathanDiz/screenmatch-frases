package com.jonathandiz.screen_match.repository;

import com.jonathandiz.screen_match.entity.MovieQuote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieQuoteRepository extends JpaRepository<MovieQuote, Long>{
}
