package com.sun.recite.service;

import com.sun.recite.entity.Example;
import com.sun.recite.entity.Sentence;
import com.sun.recite.repository.ExampleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class ExampleService {
    @Resource
    private ExampleRepository exampleRepository;
    public Example modify(Example example) {	
    	return exampleRepository.save(example);
    }
    
    public Example getOne(long id) {
    	return exampleRepository.findById(id).orElse(null);
    }
}
