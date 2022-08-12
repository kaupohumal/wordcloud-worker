package com.wordcloud.worker.controller;

import com.wordcloud.worker.model.Word;
import com.wordcloud.worker.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class DBController {

    @Autowired
    private WordRepository wordRepository;

    public ResponseEntity<Word> addWord(Word word) {
        wordRepository.save(word);
        return new ResponseEntity<>(word, HttpStatus.CREATED);
    }
}
