package com.sun.recite.repository;

import com.sun.recite.entity.Sentence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SentenceRepository extends JpaRepository<Sentence, String> {
}
