package com.sun.recite.controller;

import com.sun.recite.annotation.Validation;
import com.sun.recite.entity.Example;
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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/sentence")
public class SentenceController {

    @Resource
    private SentenceService sentenceService;
    
    @PostMapping("/save")
    public ResponseEntity<JsonResult> save(
    		@RequestBody 
    		@Validation
    		Sentence sentence
    ){
        Sentence result = sentenceService.save(sentence);
        if(result != null){
            return ResponseEntity.ok(JsonResult.success());
        }
    	return ResponseEntity.ok(JsonResult.error("插入失败"));
    }
    
    @GetMapping("/get/{id}")
    public ResponseEntity<JsonResult> get(@PathVariable long id){
    	Sentence sentence = sentenceService.getOne(id);
    	if(sentence == null) {
    		return ResponseEntity.ok(JsonResult.error("句型不存在,请填写正确参数"));
    	}
    	return ResponseEntity.ok(JsonResult.success(sentence));
    }
    
    @GetMapping("/")
    public ResponseEntity<JsonResult> page(@PageableDefault(value = 10,sort = {"createTime"},direction = Sort.Direction.DESC) Pageable pageable){
       Page<Sentence> sentences = sentenceService.pageable(pageable);
       Map<String, Object> map = new HashMap<String, Object>();
       map.put("content", sentences.getContent());
       map.put("total", sentences.getTotalElements());
       return ResponseEntity.ok(JsonResult.success(map));
    }
    
    @PostMapping("/example/{id}")
    public ResponseEntity<JsonResult> newExample(
    		@PathVariable
    		long id,
    		@RequestBody 
    		@Validation
    		Example example){
    	
    	return null;	
    }
    
    @PostMapping("/edit")
    public ResponseEntity<JsonResult> edit(
    		@RequestBody 
    		@Validation
    		Sentence sentence
    ){
        if(StringUtils.isEmpty(sentence.getId())) {
        	return ResponseEntity.ok(JsonResult.error("更新操作句型Id不能为空"));
        }
        Sentence updateSentence = sentenceService.getOne(sentence.getId());
        if(updateSentence == null) {
        	return ResponseEntity.ok(JsonResult.error("该句型不存在无法执行更新操作"));
        }
        //JPA是否自动
        sentence.setCreateTime(updateSentence.getCreateTime());
        
        Sentence result = sentenceService.save(sentence);
        if(result != null) {
        	return ResponseEntity.ok(JsonResult.success());
        }
        return ResponseEntity.ok(JsonResult.error("更新失败"));
    }
    

}
