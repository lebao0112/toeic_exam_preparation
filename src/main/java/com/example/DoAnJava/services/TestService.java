package com.example.DoAnJava.services;

import com.example.DoAnJava.Repository.ChoiceRepository;
import com.example.DoAnJava.Repository.PartRepository;
import com.example.DoAnJava.Repository.QuestionRepository;
import com.example.DoAnJava.Repository.TestRepository;
import com.example.DoAnJava.models.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private PartRepository partRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ChoiceRepository choiceRepository;

    public void saveTest(Tests test) {
        testRepository.save(test);
    }

    public List<Tests> getAllTests() {
        return testRepository.findAll();
    }

    @Transactional
    public Tests createTest(TestDTO testDTO) {
        Tests test = new Tests();
        test.setTestName(testDTO.getTestName());
        test.setParts(new ArrayList<>());

        for (TestDTO.PartDTO partDTO : testDTO.getParts()) {
            Parts part = new Parts();
            part.setPartNumber(partDTO.getPartNumber());
            part.setPartType(Parts.PartType.valueOf(partDTO.getPartType()));
            part.setTest(test);
            part.setQuestions(new ArrayList<>());

            for (TestDTO.PartDTO.QuestionDTO questionDTO : partDTO.getQuestions()) {
                Questions question = new Questions();
                question.setQuestionNumber(questionDTO.getQuestionNumber());
                question.setQuestionText(questionDTO.getQuestionText());
                question.setImageURL(questionDTO.getImageURL());
                question.setAudioURL(questionDTO.getAudioURL());
                question.setPart(part);
                question.setChoices(new ArrayList<>());

                for (TestDTO.PartDTO.QuestionDTO.ChoiceDTO choiceDTO : questionDTO.getChoices()) {
                    Choices choice = new Choices();
                    choice.setChoiceText(choiceDTO.getChoiceText());
                    choice.setIsCorrect(choiceDTO.getIsCorrect());
                    choice.setQuestion(question);
                    question.getChoices().add(choice);
                }
                part.getQuestions().add(question);
            }
            test.getParts().add(part);
        }

        return testRepository.save(test);
    }


}
