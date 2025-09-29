package com.example.thendral.dto;

public class QuoteDto {
    private String text;
    private String category;
    private String author;

    public QuoteDto() {}

    public QuoteDto(String text, String category, String author) {
        this.text = text;
        this.category = category;
        this.author = author;
    }

    // getters and setters
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
}
