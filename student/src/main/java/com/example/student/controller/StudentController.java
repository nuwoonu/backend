package com.example.student.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.student.dto.StudentDTO;
import com.example.student.service.StudentService;

import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@RequestMapping("/student")
@Log4j2
@Controller
public class StudentController {
    private final StudentService studentService;

    // 컨트롤러 짤때 생각할것
    // 학생 등록 :
    // GET: /student/register(등록화면 보여주기)
    // POST: /student/register
    // 학생정보수정
    // GET:/student/modify?id=숫자 (학생정보 보여주기)
    // POST: /student/modify
    // 학생정보조회
    // GET /student/read?id=숫자
    // 학생 탈퇴
    // POST: /student/remove
    // 학생 전체조회
    // GET: /student/list
    @GetMapping("/register")
    public void getRegister() {
        log.info("등록하면 보여주기");

    }

    @PostMapping("/register")
    public String postRegister(StudentDTO dto) {
        log.info("등록 {}", dto);
        String name = studentService.insert(dto);

        return "redirect:/student/list";
    }

    @GetMapping({ "/modify", "read" })
    public void getModify(@RequestParam Long id, Model model) {
        log.info("조회 {}", id);

        StudentDTO dto = studentService.read(id);
        model.addAttribute("dto", dto);
    }

    @PostMapping("/modify")
    public String postModify(StudentDTO dto, RedirectAttributes rttr) {
        log.info("수정 {}", dto);
        Long id = studentService.update(dto);
        // 상세조회 이동
        rttr.addAttribute("id", id);
        return "redirect:/student/read";
    }

    @PostMapping("/remove")
    public String postRemove(StudentDTO dto) {
        log.info("탈퇴 {}", dto);
        studentService.delete(dto.getId());
        return "redirect:/student/list";
    }

    @GetMapping("/list")
    public void getList(Model model) {
        log.info("전체 조회");
        List<StudentDTO> list = studentService.readAll();
        model.addAttribute("list", list);

    }

}
