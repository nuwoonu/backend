package com.example.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@RequestMapping("/book")
@Log4j2
@Controller
public class BookController {

    @GetMapping("/register")
    public void getRegister() {
        log.info("등록 화면 요청");
    }

}
