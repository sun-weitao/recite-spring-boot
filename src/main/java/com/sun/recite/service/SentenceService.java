package com.sun.recite.service;

import com.sun.recite.entity.Sentence;
import com.sun.recite.repository.SentenceRepository;
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
    public void save(Sentence sentence){
        sentence.setId(UUID.randomUUID().toString());
        sentence.setCreateTime(now);
        sentenceRepository.save(sentence);
    }
}
