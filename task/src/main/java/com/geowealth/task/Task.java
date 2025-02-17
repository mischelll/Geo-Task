package com.geowealth.task;

import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Task {

    private final WordsLoader wordsLoader;

    public Task() {
        wordsLoader = new WordsLoader();
    }

    /**
     * Find 9-letter words that are still valid after removing one letter each time
     *
     * @return all valid 9-letter words
     * @throws URISyntaxException
     */
    public Set<String> findAllValid9LetterWords() throws URISyntaxException {
        var startTime = System.currentTimeMillis();
        System.out.println("START TIME (FETCHING ALL WORDS): " + LocalDateTime.now());
        final Set<String> allWords = wordsLoader.loadAllWords();
        var endTime = System.currentTimeMillis();
        System.out.println("FINISHED TIME (FETCHING ALL WORDS): " + LocalDateTime.now());

        var elapsedTimeMs = endTime - startTime;
        var elapsedTimeSec = elapsedTimeMs / 1000.0;

        System.out.println("TOTAL TIME (FETCHING ALL WORDS): " + elapsedTimeMs + " ms (" + elapsedTimeSec + " seconds)");

        final Set<String> all9LetterWords = allWords
                .stream()
                .filter(word -> word.length() == 9)
                .collect(Collectors.toSet());
        var allValid9LetterWords = new HashSet<String>();

        for (String word : all9LetterWords) {
            if (checkIfWordIsValid(word, allWords, new HashSet<>())) {
                allValid9LetterWords.add(word);
            }
        }

        return allValid9LetterWords;
    }

    private boolean checkIfWordIsValid(String word, final Set<String> allWords, Set<String> checkedWords) {
        if (word.length() == 1 && (word.equalsIgnoreCase("I") || word.equalsIgnoreCase("A"))) {
            return true;
        }

        if (checkedWords.contains(word)) return false;
        checkedWords.add(word);

        for (int i = 0; i < word.length(); i++) {
            String newWord = word.substring(0, i) + word.substring(i + 1);

            if (allWords.contains(newWord) || newWord.equalsIgnoreCase("I") || newWord.equalsIgnoreCase("A")) {
                if (checkIfWordIsValid(newWord, allWords, checkedWords)) {
                    return true;
                }
            }
        }
        return false;
    }
}