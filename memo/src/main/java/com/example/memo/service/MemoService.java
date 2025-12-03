package com.example.memo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.memo.dto.MemoDTO;
import com.example.memo.entity.Memo;
import com.example.memo.repository.MemoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Log4j2
@Service

public class MemoService {
    @Autowired
    // private MemoRepository memoRepository;
    // private ModelMapper modelMapper;

    private final MemoRepository memoRepository;
    private final ModelMapper modelMapper;

    public List<MemoDTO> readAll() {
        List<Memo> memos = memoRepository.findAll();

        // Entity : serivce => repository, repository => service
        // ~~ DTO : serivce => controller, controller => serivce
        // 리턴하기 전 Memo entity => MemoDTO 로 변경 후 리턴
        // List<MemoDTO> list = new ArrayList<>();
        // for (Memo memo : memos) {
        // // MemoDTO dto =
        // //
        // MemoDTO.builder().id(memo.getId()).text(memo.getText()).createDate(memo.getCreateDate())
        // // .updateDate(memo.getUpdateDate()).build();

        // MemoDTO dto = modelMapper.map(memo, MemoDTO.class);
        // list.add(dto);
        // }
        List<MemoDTO> list = memos.stream().map(memo -> modelMapper.map(memo, MemoDTO.class))
                .collect(Collectors.toList());
        return list;
    }

    // 메모 하나 조회
    public MemoDTO read(Long id) {
        // findById ==> select * from 테이블 where id=몇번;
        // 방법1
        // Memo memo = memoRepository.findById(id).get(); // optional을 받아냄.

        // 방법2
        // Optional<Memo> result = memoRepository.findById(id);
        // Memo memo = null;
        // if (result.isPresent()) // 존재하면 갖구와.
        // {
        // memo = result.get();
        // }

        // 못찾으면 NoSuchElementException 있으면 value 날려준다.
        Memo memo = memoRepository.findById(id).orElseThrow();

        // Entity => dto로 변환 후에 리턴하는 코드를 만들어야한다. db사용 구조
        return modelMapper.map(memo, MemoDTO.class);
    }

    // 하나 수정(memo)
    public Long modify(MemoDTO dto) {
        // 1) 수정대상 찾기
        Memo memo = memoRepository.findById(dto.getId()).orElseThrow();
        // 2) 변경
        memo.changeText(dto.getText());
        // memo = memoRepository.save(memo);
        // return memo.getId();

        return memoRepository.save(memo).getId();
    }
    // 하나 수정

    public void remove(Long id) {
        memoRepository.deleteById(id);
    }

    // 새로운 메모 삽입
    public Long insert(MemoDTO dto) {
        // dto(원본) => entity(바꾸고자하는건)로 변환해줘야한다.
        Memo memo = modelMapper.map(dto, Memo.class);
        return memoRepository.save(memo).getId();
    }
}
