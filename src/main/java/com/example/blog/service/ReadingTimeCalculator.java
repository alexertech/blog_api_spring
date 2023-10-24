package com.example.blog.service;

public class ReadingTimeCalculator {

    private static final int AVERAGE_READING_SPEED_WPM = 275; // Average reading speed in words per minute

    public static int calculateReadingTime(String body) {
        if (body == null || body.trim().isEmpty()) return 0;
        String[] words = body.split("\\s+");
        int wordCount = words.length;
        return Math.round(wordCount / (float) AVERAGE_READING_SPEED_WPM);
    }
}
