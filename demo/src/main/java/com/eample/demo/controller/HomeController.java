package com.eample.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Log4j2 // 로그를 저장하는데 사용되는 라이브러리 
@Controller 
public class HomeController {
    // URL 설정 메서드 및 어노테이션
    //GetMapping ==> get요청으로 들어올 때 의미.
    @GetMapping("/home") //URL 이름 경로
    public void getHome() {
       log.info("home 요청"); // == System.out.println() 과 똑같은것.
    }

    @GetMapping("/add")
    public String getAdd() {
        return "result";
    }
    
    @GetMapping("/calc")
    public void getMethodName() {
        log.info("calc get");
    }
    
    @PostMapping("/calc")
    public void postCalc(int num1) {
        log.info("calc post {}",num1);
    }
    
}