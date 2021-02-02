package com.sun.recite.controller;

import com.sun.recite.annotation.Validation;
import com.sun.recite.entity.Example;
import com.sun.recite.exception.HandleException;
import com.sun.recite.models.JsonResult;
import com.sun.recite.service.ExampleService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/example")
public class ExampleController {
	

    @Resource
    ExampleService exampleService;
    
    @PostMapping("/edit")
    public ResponseEntity<JsonResult> edit(
    		@RequestBody 
    		@Validation 
    		Example example){
    	if(example.getId() == null) {
    		return ResponseEntity.ok(JsonResult.error("id不为空"));
    	}
    	Example updateExample = exampleService.getOne(example.getId());
    	if(updateExample == null) {
    		return ResponseEntity.ok(JsonResult.error("该id不存在"));
    	}
		example.setCreateTime(updateExample.getCreateTime());
		example.setUpdateTime(LocalDateTime.now());
    	Example resultExample = exampleService.modify(example);
    	if(resultExample != null) {
    		return ResponseEntity.ok(JsonResult.success());
    	}
    	return ResponseEntity.ok(JsonResult.error("编辑失败"));
    }
    @DeleteMapping("/del/{id}")
    public ResponseEntity<JsonResult> del(@PathVariable long id) throws HandleException{
    	try {
    		exampleService.del(id);
    	}catch(Exception e) {
    		throw new HandleException("删除失败");
    	}
    	return ResponseEntity.ok(JsonResult.success());
    }
}
