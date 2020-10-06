package com.sun.recite.service;

import com.sun.recite.entity.Sentence;
import com.sun.recite.repository.SentenceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.UUID;

@Service
public class SentenceService {
    @Resource
    public SentenceRepository sentenceRepository;
    final static Date now = new Date();
    @Transactional
    public Sentence save(Sentence sentence){
        sentence.setId(UUID.randomUUID().toString());
        sentence.setCreateTime(now);
        return sentenceRepository.save(sentence);
    }

    public Page<Sentence> pageable(final Pageable pageable){
        return sentenceRepository.findAll(pageable);
    }
}
