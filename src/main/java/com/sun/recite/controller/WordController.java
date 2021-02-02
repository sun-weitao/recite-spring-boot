package com.sun.recite.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.recite.annotation.Validation;
import com.sun.recite.entity.Example;
import com.sun.recite.entity.Word;
import com.sun.recite.exception.HandleException;
import com.sun.recite.models.JsonResult;
import com.sun.recite.service.WordService;

@RestController
@RequestMapping("/word")
public class WordController {
	@Resource
	WordService wordService;

	@GetMapping("/")
	public ResponseEntity<JsonResult> page(
			@PageableDefault(value = 10, sort = { "createTime" }, direction = Sort.Direction.DESC) Pageable pageable) {
		Page<Word> words = wordService.pageable(pageable);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("content", words.getContent());
		map.put("total", words.getTotalElements());
		return ResponseEntity.ok(JsonResult.success(map));
	}

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody @Validation Word word) {
		Word result = wordService.save(word);
		if (result != null) {
			return ResponseEntity.ok(JsonResult.success());
		}
		return ResponseEntity.ok(JsonResult.error("保存失败"));
	}
	
	@DeleteMapping("/del/{id}")
	public ResponseEntity<JsonResult> del(@PathVariable long id) throws Exception{
		try {
			wordService.del(id);
		}catch (Exception e) {
			throw new HandleException("删除失败");
		}
		return ResponseEntity.ok(JsonResult.success());
	}
	
	@PostMapping("/example/{id}")
	public ResponseEntity<JsonResult> newExample(@PathVariable long id, @RequestBody @Validation Example example) {
		Word word = wordService.addExample(id, example);
		if(word != null)
		{
			return ResponseEntity.ok(JsonResult.success());
		}
		return ResponseEntity.ok(JsonResult.error("操作失败"));
	}
}
