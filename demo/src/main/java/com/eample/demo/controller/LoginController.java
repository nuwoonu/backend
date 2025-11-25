package com.eample.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eample.demo.dto.LoginDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMethod;



@Log4j2
@Controller
@RequestMapping("/member")
@AllArgsConstructor
@ToString
@Getter
@Setter



public class LoginController {


    @GetMapping("/login")
    public void getlogin() {
        log.info("로그인 요청 /member/login");
    }
    
    //  @PostMapping("/login")
    // public void postlogin(String id, String password) {
        
    // }
     @PostMapping("/login")
    public void postlogin(@ModelAttribute("login") LoginDTO login) // *****html에서 클래스명의 첫시작을 소문자로*****
     {
        log.info("login post");
        log.info("{}",login);
        
        



    }

    //
    @GetMapping("path")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    

    // 아래 코드는 옛날 맵핑 방식
    // @RequestMapping(path="/test", method=RequestMethod.GET)
    // public String requestMethodName(@RequestParam String param) {
    //     return new String();
    // }
    // @RequestMapping(path="/test", method=RequestMethod.POST)
    // public String requestMethodName2(@RequestParam String param) {
    //     return new String();
    // }
    

}
