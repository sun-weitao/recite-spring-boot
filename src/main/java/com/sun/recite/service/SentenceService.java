package com.sun.recite.service;

import com.sun.recite.entity.Example;
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
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
    
    public List<Sentence> findAll(){
    	return sentenceRepository.findAll();
    }

    public Page<Sentence> pageable(final Pageable pageable){
        return sentenceRepository.findAll(pageable);
    }
    
    public Sentence addExample(long sentence_id,Example example) {
    	Sentence sentence = getOne(sentence_id);
    	if(sentence != null) {
    		List<Example> examples = sentence.getExamples();
    		examples.add(example);
    		sentence.setExamples(examples);
    		return save(sentence); 
    	}
    	return null;	
    }
    
    public boolean modifyExample(long sentence_id,Example example)
    {
    	Sentence sentence = getOne(sentence_id);
    	if(sentence != null) {
    		List<Example> examples = sentence.getExamples().stream().map(e -> {
    			if(e.getId() == example.getId()) {
    				return example;
    			}
    			return e;
    		}).collect(Collectors.toList());
    		sentence.setExamples(examples);
    		return save(sentence) != null;
    	}
    	return false;
    }
    
}
