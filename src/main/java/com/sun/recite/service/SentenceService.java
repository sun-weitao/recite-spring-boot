package com.sun.recite.service;

import com.sun.recite.entity.Sentence;
import com.sun.recite.repository.SentenceRepository;

import net.bytebuddy.description.annotation.AnnotationDescription.Loadable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.UUID;

@Service
public class SentenceService {
    @Resource
    public SentenceRepository sentenceRepository;
    
    @Transactional
    public Sentence save(Sentence sentence) {
    	return sentenceRepository.save(sentence);
    }
    
    public Sentence getOne(long id) {
    	return sentenceRepository.findById(id).orElse(null);
    }

    public Page<Sentence> pageable(final Pageable pageable){
        return sentenceRepository.findAll(pageable);
    }
    
    
    
}
