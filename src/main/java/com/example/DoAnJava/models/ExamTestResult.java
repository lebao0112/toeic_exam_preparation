package com.example.DoAnJava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="exam_test_result")
public class ExamTestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id", nullable = false)
    private Integer resultId;

    @Column(name = "correct_questions") //so  cau dung
    private int correctQuestions;

    @Column(name = "incorrect_questions")
    private int incorrectQuestions;

    @Column(name = "do_exam_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime doExemDate;


    @Column(name = "correct_reading")
    private int correctReading;

    @Column(name = "correct_listening")
    private int correctListening;

    @ManyToOne
    @JoinColumn(name="id",nullable= false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name="exam_test_id",nullable= false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private ExamTest examTest;

    @PrePersist
    protected void onCreate() {
        doExemDate = LocalDateTime.now();
    }
}
