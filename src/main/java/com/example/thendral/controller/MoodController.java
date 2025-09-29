package com.example.thendral.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.thendral.service.MoodService;
import com.example.thendral.dto.MoodEntryDto;
import java.util.List;

@RestController
@RequestMapping("/mood")
public class MoodController {
    @Autowired
    private MoodService moodService;

    @PostMapping("/add")
    public String addMood(@RequestBody MoodEntryDto moodEntryDto) {
        return moodService.addMoodEntry(moodEntryDto);
    }

    @GetMapping("/user/{userId}")
    public List<MoodEntryDto> getUserMoods(@PathVariable Long userId) {
        return moodService.getUserMoods(userId);
    }
}
