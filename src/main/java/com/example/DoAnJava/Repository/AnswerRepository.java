package com.example.DoAnJava.Repository;

import com.example.DoAnJava.models.Answers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answers, Integer> {
}
