package com.example.DoAnJava.Controller;

import com.example.DoAnJava.models.ExamTest;
import com.example.DoAnJava.services.ExamTestService;
import com.example.DoAnJava.importer.ExamQuestionImporter;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RequestMapping("/tests")
@RequiredArgsConstructor
@Controller
public class ExamTestController {
    private final ExamTestService examTestService;

    private final ExamQuestionImporter examQuestionImporter;
    @GetMapping
    public String listTests(Model model) {
        model.addAttribute("tests",examTestService.findAll());
        return "tests/list-tests";
    }

    @GetMapping("/create")
    public String showCreateTestForm(Model model) {
        model.addAttribute("examTest", new ExamTest());
        return "tests/create-test";
    }

    @PostMapping("/create")
    public String createTest(@ModelAttribute("examTest") ExamTest examTest,
                             @RequestParam("file") MultipartFile file,
                             @RequestParam("imageFiles") MultipartFile[] imageFiles,
                             @RequestParam("audioFiles") MultipartFile[] audioFiles,
                             Model model) {
        // Save the ExamTest entity
        ExamTest savedExamTest = examTestService.save(examTest);

        // Process the uploaded file and add questions
        try {
            String filePath = saveUploadedFile(file);
            examQuestionImporter.importExcelFile(filePath, savedExamTest.getExamTestId());

            // Process the uploaded image files
            for (MultipartFile imageFile : imageFiles) {
                saveUploadedResourceFiles(imageFile, "static/images/test-images//"+savedExamTest.getTitle());
            }

            // Process the uploaded audio files
            for (MultipartFile audioFile : audioFiles) {
                saveUploadedResourceFiles(audioFile, "static/audio/test-audio//"+savedExamTest.getTitle());
            }

            return "redirect:/tests";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "An error occurred while creating the test. Please try again.");
            return "tests/create-test";
        }


    }

    private String saveUploadedFile(MultipartFile file) throws IOException {
        String filePath = System.getProperty("java.io.tmpdir") + "/" + file.getOriginalFilename();
        file.transferTo(new java.io.File(filePath));
        return filePath;
    }

    private void saveUploadedResourceFiles(MultipartFile file, String folderName) throws IOException {
        Path directory = Paths.get("src/main/resources", folderName);
        if (!Files.exists(directory)) {
            Files.createDirectories(directory);
        }
        Path filePath = directory.resolve(file.getOriginalFilename());
        Files.copy(file.getInputStream(), filePath);
    }

}
