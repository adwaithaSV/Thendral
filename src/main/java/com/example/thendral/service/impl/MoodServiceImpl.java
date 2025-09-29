package com.example.thendral.service.impl;

import com.example.thendral.dto.MoodEntryDto;
import com.example.thendral.model.MoodEntry;
import com.example.thendral.repository.MoodEntryRepository;
import com.example.thendral.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MoodServiceImpl implements MoodService {
    @Autowired
    private MoodEntryRepository moodEntryRepository;

    @Override
    public String addMoodEntry(MoodEntryDto moodEntryDto) {
        // Placeholder: implement actual save logic
        return "Mood entry added (placeholder)";
    }

    @Override
    public List<MoodEntryDto> getUserMoods(Long userId) {
        // Placeholder: return empty list or implement actual logic
        return new ArrayList<>();
    }
}
