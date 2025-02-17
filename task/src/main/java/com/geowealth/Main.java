package com.geowealth;

import com.geowealth.task.Task;
import com.geowealth.task.WordsLoader;

import java.net.URISyntaxException;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) throws URISyntaxException {
        var task = new Task(new WordsLoader());
        var startTime = System.currentTimeMillis();
        System.out.println("START TIME (TASK): " + LocalDateTime.now());
        var allValid9LetterWords = task.findAllValid9LetterWords();
        var endTime = System.currentTimeMillis();
        System.out.println("FINISHED TIME (TASK): " + LocalDateTime.now());

        var elapsedTimeMs = endTime - startTime;
        var elapsedTimeSec = elapsedTimeMs / 1000.0;

        System.out.println("FOUND WORDS COUNT: " + allValid9LetterWords.size());
        System.out.println("TOTAL TIME (TASK): " + elapsedTimeMs + " ms (" + elapsedTimeSec + " seconds)");

    }

}