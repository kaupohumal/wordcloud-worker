package com.wordcloud.worker.repository;

import com.wordcloud.worker.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, Long> {
}
