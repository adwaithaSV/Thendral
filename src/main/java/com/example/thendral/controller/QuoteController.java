package com.example.thendral.controller;

import com.example.thendral.model.Quote;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;
import java.util.stream.Collectors;
public class QuoteController {
    private static final Map<String, List<Quote>> STATIC_QUOTES = Map.of(
        "happy", List.of(
            new Quote("Happiness is a journey, not a destination.", "happy", "System"),
            new Quote("Smile, it's free therapy.", "happy", "System"),
            new Quote("Joy is the simplest form of gratitude.", "happy", "System"),
            new Quote("Let your smile change the world.", "happy", "System")
        ),
        "anxious", List.of(
            new Quote("You are stronger than your anxiety.", "anxious", "System"),
            new Quote("Breathe. You’re going to be okay.", "anxious", "System"),
            new Quote("This too shall pass.", "anxious", "System"),
            new Quote("Worry less, live more.", "anxious", "System")
        ),
        "tired", List.of(
            new Quote("Rest is not idleness.", "tired", "System"),
            new Quote("Recharge and come back stronger.", "tired", "System"),
            new Quote("Take time to do what makes your soul happy.", "tired", "System"),
            new Quote("Fatigue is the best pillow.", "tired", "System")
        ),
        "sad", List.of(
            new Quote("Every storm runs out of rain.", "sad", "System"),
            new Quote("Sadness flies away on the wings of time.", "sad", "System"),
            new Quote("It’s okay to not be okay.", "sad", "System"),
            new Quote("Tears are words the heart can’t express.", "sad", "System")
        ),
        "excited", List.of(
            new Quote("The best is yet to come!", "excited", "System"),
            new Quote("Let your excitement be contagious.", "excited", "System"),
            new Quote("Dream big, start small.", "excited", "System"),
            new Quote("Live life with enthusiasm.", "excited", "System")
        ),
        "calm", List.of(
            new Quote("Peace begins with a smile.", "calm", "System"),
            new Quote("Stay calm and carry on.", "calm", "System"),
            new Quote("Serenity is not freedom from the storm, but peace amid the storm.", "calm", "System"),
            new Quote("Let your heart be still.", "calm", "System")
        )
    );
    private final List<Quote> userQuotes = new ArrayList<>();

    @GetMapping("/mood")
    public String getQuotesByMood(@RequestParam(required = false) String mood, Model model) {
        List<Quote> quotes = new ArrayList<>();
        quotes.addAll(STATIC_QUOTES.getOrDefault(mood, List.of()));
        quotes.addAll(userQuotes.stream().filter(q -> q.getCategory().equalsIgnoreCase(mood)).collect(Collectors.toList()));
        Collections.shuffle(quotes);
        List<Quote> selectedQuotes = quotes.stream().limit(3).collect(Collectors.toList());
        model.addAttribute("quotes", selectedQuotes);
        model.addAttribute("selectedMood", mood);
        return "quotes";
    }

    @PostMapping("/add")
    public String addQuote(@RequestParam String mood, @RequestParam String text, Model model) {
        Quote newQuote = new Quote(text, mood, "User");
        userQuotes.add(newQuote);
        return "redirect:/quotes/mood?mood=" + mood;
    }
}
