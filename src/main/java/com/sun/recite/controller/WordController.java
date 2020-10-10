package com.sun.recite.controller;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.recite.annotation.Validation;
import com.sun.recite.entity.Word;
import com.sun.recite.models.JsonResult;
import com.sun.recite.service.WordService;

@RestController
@RequestMapping("/word")
public class WordController {
	@Resource
	WordService wordService;
	
	@GetMapping("/")
	public ResponseEntity<?> index(@PageableDefault(value = 10,sort = {"createTime"},direction = Sort.Direction.DESC) Pageable pageable){
		Page<Word> words = wordService.pageable(pageable);
		return ResponseEntity.ok(JsonResult.success(words.getContent()));
	}
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody @Validation Word word){
		Word result = wordService.save(word);
		if(result != null) {
			return ResponseEntity.ok(JsonResult.success());
		}
		return ResponseEntity.ok(JsonResult.error("插入失败"));
	}
}
