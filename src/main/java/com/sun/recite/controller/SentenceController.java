package com.sun.recite.controller;

import com.sun.recite.annotation.Validation;
import com.sun.recite.entity.Sentence;
import com.sun.recite.models.JsonResult;
import com.sun.recite.service.SentenceService;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/sentence")
public class SentenceController {

    @Resource
    public SentenceService sentenceService;

    @GetMapping("/index")
    public ResponseEntity<?> index(@PageableDefault(value = 10,sort = {"createTime"},direction = Sort.Direction.DESC) Pageable pageable){
    	
    	return null;
    }
    
    @PostMapping("/save")
    public ResponseEntity<JsonResult> save(
    		@RequestBody 
    		@Validation
    		Sentence sentence
    ){
    	System.out.println(sentence.getText());
    	return ResponseEntity.ok(JsonResult.success());
    }

}
