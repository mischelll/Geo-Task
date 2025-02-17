package com.geowealth.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class WordsLoader {

    private final static String ALL_WORDS_URL = "https://raw.githubusercontent.com/nikiiv/JavaCodingTestOne/master/scrabble-words.txt";
    private final static Logger LOGGER = Logger.getLogger(WordsLoader.class.getName());

    /**
     * Loads all words from the English language.
     *
     * @return allWords - list containing all the words in the English language
     * @throws URISyntaxException
     */
    public Set<String> loadAllWords() throws URISyntaxException {
        var wordsUrl = new URI(ALL_WORDS_URL); //URI constructor used since URL is deprecated since version 20. Task is written with version 21.
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(wordsUrl.toURL().openConnection().getInputStream()))) {
            return reader.lines().skip(2).collect(Collectors.toSet());
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Something went wrong while loading words!");
            return new HashSet<>();
        }

    }
}
