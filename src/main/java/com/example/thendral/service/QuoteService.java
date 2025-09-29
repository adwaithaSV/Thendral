package com.example.thendral.service;

import com.example.thendral.dto.QuoteDto;
import java.util.List;

public interface QuoteService {
    List<QuoteDto> getQuotesByMood(String mood);
    String addQuote(QuoteDto quoteDto);
}
