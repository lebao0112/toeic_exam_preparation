package com.example.DoAnJava.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/practice")
@Controller
public class PracticeController {
    @GetMapping
    public String index() {
        return "practice/index";
    }


}
