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
public class ExamTestResultService {
    @Autowired
    private ExamTestResultRepository examTestResultRepository;

    public List<ExamTestResult> findAll() {
        return examTestResultRepository.findAll();
    }

    public Optional<ExamTestResult> findById(Integer id) {
        return examTestResultRepository.findById(id);
    }

    public ExamTestResult save(ExamTestResult examTestResult) {
        return examTestResultRepository.save(examTestResult);
    }

    public void deleteById(Integer id) {
        examTestResultRepository.deleteById(id);
    }
}
