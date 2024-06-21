package com.example.DoAnJava.Repository;

import com.example.DoAnJava.models.FlashCard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlashCardRepository extends JpaRepository<FlashCard, Long> {
    // Additional methods for custom queries if needed
}
