package com.example.DoAnJava.Repository;

import com.example.DoAnJava.models.ExamTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamTestRepository extends JpaRepository<ExamTest, Integer> {
}