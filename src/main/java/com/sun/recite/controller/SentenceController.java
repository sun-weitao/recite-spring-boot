package com.sun.recite.controller;

import com.sun.recite.models.JsonResult;
import com.sun.recite.service.SentenceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/sentence")
public class SentenceController {

    @Resource
    public SentenceService sentenceService;

    @GetMapping("/index")
    public String index(){
        return "Hello,index";
    }
    @GetMapping("/save")
    public JsonResult save(){
        return JsonResult.success();
    }

}
