package com.sun.recite.service;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sun.recite.entity.Word;
import com.sun.recite.repository.WordRepository;

@Service
public class WordService {
	
	@Resource
	WordRepository wordRepository;
	final static Date now = new Date();
	public Word save(Word word) {
		word.setId(UUID.randomUUID().toString());
		word.setCreateTime(now);
		return wordRepository.save(word);
	}
	
	public Page<Word> pageable(final Pageable pageable){
		return wordRepository.findAll(pageable);
	}
}
