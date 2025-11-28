package com.example.jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpa.entity.Board;
import com.example.jpa.entity.Item;
import com.example.jpa.entity.constant.ItemSellStatus;

@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void insertTest() {
        // Board 10개 삽입
        for (int i = 1; i < 11; i++) {
            Board board = Board.builder().title("board title" + i).content("board content" + i).writer("writer" + i)
                    .build();
            boardRepository.save(board);

        }
    }

    // 수정 : title, content
    @Test
    public void updateTest() {
        Board board = boardRepository.findById(1L).get();
        board.changeTitle("board title");
        board.changeContent("change content");
        boardRepository.save(board);
    }

    // 조회
    @Test
    public void readTest() {
        System.out.println(boardRepository.findById(2L).get());
    }

    @Test
    public void read2Test() {
        boardRepository.findAll().forEach(board -> System.out.println(board));
    }

    // 삭제
    @Test
    public void deleteTest() {
        boardRepository.deleteById(9L);
    }

}
