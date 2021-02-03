package com.sun.recite.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sun.recite.entity.Example;
import com.sun.recite.entity.Word;
import com.sun.recite.repository.WordRepository;

@Service
public class WordService {
	
	@Resource
	WordRepository wordRepository;
	
	public List<Word> findAll(){
		return wordRepository.findAll();
	}
	@Transactional
	public Word save(Word word) {
		return wordRepository.save(word);
	}
	
	public Page<Word> pageable(final Pageable pageable){
		return wordRepository.findAll(pageable);
	}
	
	public void del(long id) {
		wordRepository.deleteById(id);
	}
	
	public Word addExample(long word_id,Example example) {
		Word word = wordRepository.getOne(word_id);
		if(word != null)
		{
			List<Example> examples = word.getExamples();
			examples.add(example);
			word.setExamples(examples);
			return save(word);
		}
		return null;
	}
}
