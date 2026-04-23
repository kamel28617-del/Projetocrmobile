package com.example.projetocrmobile;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TextProcessor {
    
    // Common stop words to exclude from keywords
    private static final Set<String> STOP_WORDS = new HashSet<>(Arrays.asList(
        "the", "a", "an", "and", "or", "but", "in", "on", "at", "to", "for",
        "of", "with", "by", "from", "as", "is", "was", "are", "were", "be",
        "been", "being", "have", "has", "had", "do", "does", "did", "will",
        "would", "could", "should", "may", "might", "must", "can", "this",
        "that", "these", "those", "i", "you", "he", "she", "it", "we", "they",
        "what", "which", "who", "when", "where", "why", "how", "all", "each",
        "every", "both", "few", "more", "most", "other", "some", "such", "no",
        "nor", "not", "only", "same", "so", "than", "too", "very", "just",
        "about", "above", "after", "before", "between", "during", "through",
        "into", "until", "up", "down", "out", "off", "over", "under", "again",
        "further", "then", "once", "here", "there", "now", "if", "because"
    ));

    /**
     * Extract keywords from text
     */
    public static String extractKeywords(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }

        // Convert to lowercase and split into words
        String[] words = text.toLowerCase()
                .replaceAll("[^a-z0-9\\s]", "") // Remove special characters
                .split("\\s+");

        // Filter out stop words and get unique words
        String keywords = Arrays.stream(words)
                .filter(word -> !STOP_WORDS.contains(word) && word.length() > 3)
                .distinct()
                .limit(10) // Get top 10 keywords
                .collect(Collectors.joining(", "));

        return keywords.isEmpty() ? "No keywords found" : keywords;
    }

    /**
     * Generate a simple summary by extracting first sentences
     */
    public static String generateSummary(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }

        String[] sentences = text.split("[.!?]+");
        int summaryLength = Math.min(3, sentences.length);
        
        StringBuilder summary = new StringBuilder();
        for (int i = 0; i < summaryLength; i++) {
            String sentence = sentences[i].trim();
            if (!sentence.isEmpty()) {
                summary.append(sentence).append(". ");
            }
        }

        return summary.toString().isEmpty() ? text.substring(0, Math.min(200, text.length())) : summary.toString();
    }
}