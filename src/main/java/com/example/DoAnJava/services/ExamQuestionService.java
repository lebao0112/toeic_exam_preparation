package com.example.DoAnJava.services;

import com.example.DoAnJava.models.ExamQuestion;
import com.example.DoAnJava.models.ExamTest;
import com.example.DoAnJava.models.ExamTestResult;
import com.example.DoAnJava.Repository.ExamQuestionRepository;
import com.example.DoAnJava.Repository.ExamTestRepository;
import com.example.DoAnJava.Repository.ExamTestResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamQuestionService {
    @Autowired
    private ExamQuestionRepository examQuestionRepository;

    public List<ExamQuestion> findAll() {
        return examQuestionRepository.findAll();
    }

    public Optional<ExamQuestion> findById(Integer id) {
        return examQuestionRepository.findById(id);
    }

    public ExamQuestion save(ExamQuestion examQuestion) {
        return examQuestionRepository.save(examQuestion);
    }

    public void deleteById(Integer id) {
        examQuestionRepository.deleteById(id);
    }
}
