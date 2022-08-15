package com.wordcloud.worker.controller;

import com.wordcloud.worker.model.Word;
import com.wordcloud.worker.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DBController {

    @Autowired
    private WordRepository wordRepository;

    public void addWord(Word word) {
        wordRepository.save(word);
    }
}
