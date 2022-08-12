package com.wordcloud.worker;

import com.wordcloud.worker.controller.DBController;
import com.wordcloud.worker.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;

@Controller
public class WorkerLogic {

    private String identifier;
    private HashMap<String, Integer> wordFrequencies;

    @Autowired
    DBController dbController;

    public void processText(String text) {

        wordFrequencies = new HashMap<>();

        String[] words = text.split("\\s");
        identifier = words[0];

        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            word = word.toLowerCase().replaceAll("[^a-zA-Z0-9õäöüÕÄÖÜ-]", "");

            if (wordFrequencies.containsKey(word)) {
                wordFrequencies.put(word, wordFrequencies.get(word) + 1);
            }
            else {
                wordFrequencies.put(word, 1);
            }
        }
        System.out.println("Text processed");
    }

    public void insertToDB() {

        for (String word : wordFrequencies.keySet()) {
            Word wordObject = new Word(identifier, word, wordFrequencies.get(word));
            dbController.addWord(wordObject);
        }
        System.out.println("Database insertion completed");
    }
}
