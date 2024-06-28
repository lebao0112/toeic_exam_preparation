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
public class ExamTestService {
    @Autowired
    private ExamTestRepository examTestRepository;

    @Autowired
    private ExamQuestionRepository examQuestionRepository;
    public List<ExamTest> findAll() {
        return examTestRepository.findAll();
    }

    public Optional<ExamTest> findById(Integer id) {
        return examTestRepository.findById(id);
    }

    public ExamTest save(ExamTest examTest) {
        return examTestRepository.save(examTest);
    }

    public void deleteById(Integer id) {
        examTestRepository.deleteById(id);
    }
    public List<ExamQuestion> findQuestionsByTestIdAndPart(Integer testId, int part) {
        return examQuestionRepository.findByTestIdAndPart(testId, part);
    }
}

