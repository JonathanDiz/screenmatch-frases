package com.jonathandiz.screen_match.repository;

import com.jonathandiz.screen_match.model.Frase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraseRepository extends JpaRepository<Frase, Long> {
}
