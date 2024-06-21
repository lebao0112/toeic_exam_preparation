package com.example.DoAnJava.Controller;


import com.example.DoAnJava.models.FlashCard;
import com.example.DoAnJava.services.FlashCardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/flashcards")
public class FlashCardController {

    private final FlashCardService cardService;

    // Show form to add a new card
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("card", new FlashCard());
        return "flashcards/add-card";
    }

    // Process form submission to add a new card
    @PostMapping("/add")
    public String addCard(@Valid FlashCard card, BindingResult result) {
        if (result.hasErrors()) {
            return "flashcards/add-card";
        }
        cardService.addCard(card);
        return "redirect:/flashcards";
    }

    // Show all cards
    @GetMapping
    public String listCards(Model model) {
        List<FlashCard> cards = cardService.getAllCards();
        model.addAttribute("cards", cards);
        return "flashcards/cards-list";
    }

    @GetMapping("/practice")
    public String praticeCards(Model model) {
        List<FlashCard> cards = cardService.getAllCards();
        model.addAttribute("cards", cards);
        return "flashcards/practice-card";
    }

    // Show form to update a card
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        FlashCard card = cardService.getCardById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid card Id:" + id));
        model.addAttribute("card", card);
        return "flashcards/update-card";
    }

    // Process form submission to update a card
    @PostMapping("/update/{id}")
    public String updateCard(@PathVariable("id") Long id, @Valid FlashCard card,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            card.setId(id);
            return "flashcards/update-card";
        }
        cardService.updateCard(card);
        return "redirect:/flashcards";
    }

    // Delete a card
    @GetMapping("/delete/{id}")
    public String deleteCard(@PathVariable("id") Long id, Model model) {
        cardService.deleteCardById(id);
        return "redirect:/flashcards";
    }
}
