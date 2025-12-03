package com.example.memo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.memo.dto.MemoDTO;
import com.example.memo.service.MemoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
@Log4j2
@RequestMapping("/memo")
public class MemoController {

    private final MemoService memoService;

    @GetMapping("/list")
    public void getlist(Model model) {
        log.info("전체 메모 요청");
        List<MemoDTO> list = memoService.readAll();
        model.addAttribute("list", list);
    }

    @GetMapping({ "/read", "modify" })
    public void getRead(@RequestParam Long id, Model model) {
        log.info("memo id : {}", id);

        MemoDTO dto = memoService.read(id);
        model.addAttribute("dto", dto);

        // /memo/read?id=1
        // /memo/modify?id=1

    }

    @PostMapping("/modify")
    public String postModify(MemoDTO dto, RedirectAttributes rttr) {
        log.info("memo 수정 {}", dto);

        Long id = memoService.modify(dto);
        // /memo/read
        rttr.addAttribute("id", id);
        return "redirect:/memo/read"; // read는 id를 무조건 받기때문에 dto에 들어있다. 따라서 rrtr을 이용해서 빼와서 id를 같이 보낸다.
    }

    @PostMapping("/remove")
    public String postRemove(@RequestParam Long id, RedirectAttributes rttr) {

        log.info("memo remove id : {}", id);

        memoService.remove(id);
        // 삭제후 list 페이지 표시
        rttr.addFlashAttribute("msg", "메모가 삭제되었습니다.");
        return "redirect:/memo/list"; // 리다이렉트로 주소로 돌려보냄. 리다이렉트가 없으면 list.html이 실행됨.
    }

    @GetMapping("/create")
    public void getCreate(@ModelAttribute("dto") MemoDTO dto) {
        log.info("추가 페이지요청");
    }

    @PostMapping("/create")
    public String postCreate(@ModelAttribute("dto") @Valid MemoDTO dto, BindingResult result, RedirectAttributes rttr) {
        log.info("추가요청 {}", dto);

        // 유효성 검증 조건에 일치하지 않는경우.
        if (result.hasErrors()) {
            return "/memo/create";

        }

        // 유효성 검증 조건에 일치하는 경우.
        Long id = memoService.insert(dto);

        rttr.addFlashAttribute("msg", id + "번 메모가 삽입되었습니다.");
        return "redirect:/memo/list";
    }

}
