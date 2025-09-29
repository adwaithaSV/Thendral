package com.example.thendral.service;

import com.example.thendral.dto.MoodEntryDto;
import java.util.List;

public interface MoodService {
    String addMoodEntry(MoodEntryDto moodEntryDto);
    List<MoodEntryDto> getUserMoods(Long userId);
}
