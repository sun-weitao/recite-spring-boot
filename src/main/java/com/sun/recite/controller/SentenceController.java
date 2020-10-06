package com.sun.recite.controller;

import com.sun.recite.annotation.Validation;
import com.sun.recite.entity.Sentence;
import com.sun.recite.models.JsonResult;
import com.sun.recite.repository.SentenceRepository;
import com.sun.recite.service.SentenceService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/sentence")
public class SentenceController {

    @Resource
    private SentenceService sentenceService;

    @GetMapping("/index")
    public ResponseEntity<?> index(@PageableDefault(value = 10,sort = {"createTime"},direction = Sort.Direction.DESC) Pageable pageable){
        Page<Sentence> sentences = sentenceService.pageable(pageable);
    	return ResponseEntity.ok(JsonResult.success(sentences.getContent()));
    }
    
    @PostMapping("/save")
    public ResponseEntity<JsonResult> save(
    		@RequestBody 
    		@Validation
    		Sentence sentence
    ){
        System.out.println(sentence);
        Sentence result = sentenceService.save(sentence);
        if(result != null){
            return ResponseEntity.ok(JsonResult.success());
        }
    	return ResponseEntity.ok(JsonResult.error("插入失败"));
    }

}
