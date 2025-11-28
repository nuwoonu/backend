package com.example.memo.serivce;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.memo.dto.MemoDTO;
import com.example.memo.service.MemoService;

@SpringBootTest
public class MemoServiceTest {
    @Autowired
    private MemoService memoService;

    @Test
    public void readAllTest() {
        List<MemoDTO> result = memoService.readAll();
        for (MemoDTO memoDTO : result) {
            System.out.println(memoDTO);
        }
    }
}
