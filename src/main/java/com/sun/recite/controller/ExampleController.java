package com.sun.recite.controller;

import com.sun.recite.annotation.Validation;
import com.sun.recite.entity.Example;
import com.sun.recite.models.JsonResult;
import com.sun.recite.service.ExampleService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/example")
public class ExampleController {

//    @Resource
//    ExampleService exampleService;
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> index(@PathVariable String id,@PageableDefault(value = 10,sort = {"createTime"},direction = Sort.Direction.DESC) Pageable pageable){
//        List<Example> examples = exampleService.pageable(id,pageable).getContent();
//        return ResponseEntity.ok(JsonResult.success(examples));
//    }
//
//    @PostMapping("/save")
//    public ResponseEntity<?> save(@RequestBody @Validation Example example){
//        if(exampleService.save(example) != null){
//            return ResponseEntity.ok(JsonResult.success());
//        }
//        return ResponseEntity.ok(JsonResult.error("操作失败"));
//    }
}
