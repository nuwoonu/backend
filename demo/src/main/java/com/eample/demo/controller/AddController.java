package com.eample.demo.controller;

import org.springframework.stereotype.Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Log4j2
@Controller
public class AddController {
    @GetMapping("/exam3")
    public void getExam3()
    {
        log.info("exam3 페이지 요청");
    }
    @PostMapping("/exam3")
    public void postExam3() 
    {
    
    }
    
}
