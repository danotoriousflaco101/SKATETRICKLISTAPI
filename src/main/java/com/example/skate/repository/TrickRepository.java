package com.example.skate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.skate.model.Trick;

public interface TrickRepository extends JpaRepository<Trick, Long> {
    // Aggiungi qui eventuali metodi personalizzati
}