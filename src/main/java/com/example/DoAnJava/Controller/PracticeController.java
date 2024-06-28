package com.example.DoAnJava.Controller;

import com.example.DoAnJava.models.ExamQuestion;
import com.example.DoAnJava.models.ExamTest;
import com.example.DoAnJava.services.ExamQuestionService;
import com.example.DoAnJava.services.ExamTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@RequestMapping("/practice")
@RequiredArgsConstructor
@Controller
public class PracticeController {
    private final ExamTestService examTestService;

    private final ExamQuestionService examQuestionServiceService;

    @GetMapping
    public String listTests(Model model) {
        model.addAttribute("tests",examTestService.findAll());
        return "practice/index";
    }

    @GetMapping("/do-test/{id}/{mins}")
    public String showDoTestPage(@RequestParam("id") Integer id, @RequestParam("mins") Integer minutes, Model model ) {
        Optional<ExamTest> examTest = examTestService.findById(id);



        if (examTest.isPresent()) {
            model.addAttribute("examTest", examTest.get());
            model.addAttribute("mins", minutes);

            for (int part = 1; part <= 7; part++) {
                List<ExamQuestion> questionsOfPart = examTestService.findQuestionsByTestIdAndPart(id, part);
                model.addAttribute("questionsOfPart" + part, questionsOfPart);
            }
            return "practice/do-test"; // Replace with your actual Thymeleaf template for viewing a test
        } else {
            return "error/404"; // Replace with your actual 404 error page
        }
    }


}
