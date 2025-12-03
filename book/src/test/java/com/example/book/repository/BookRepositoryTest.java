package com.example.book.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.book.entity.constant.Book;

import jakarta.persistence.EntityNotFoundException;

@Disabled
@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    private BookRespository bookRespository;

    @Test
    public void insert() {
        // Book book = new Book(); 이코드와 아래코드와 같음.
        Book book = Book.builder()
                .isbn("A101010")
                .title("파워 자바")
                .author("천인국")
                .price(36000)
                .build();
        bookRespository.save(book);
    }

    @Test
    public void insert2() {
        // Book book = new Book(); 이코드와 아래코드와 같음.
        IntStream.rangeClosed(0, 9).forEach(i -> {

            Book book = Book.builder()
                    .isbn("A101010" + i)
                    .title("파워 자바" + i)
                    .author("천인국" + i)
                    .price(36000)
                    .build();
            bookRespository.save(book);
        });
    }

    @Test
    public void testRead() {
        // bookRespository.findById(1L).orElse(null);
        bookRespository.findById(1L).orElseThrow();
        // bookRespository.findById(1L).orElseThrow(EntityNotFoundException::new);
        Book book = bookRespository.findById(1L).orElseThrow();
        // Optional<Book> result = bookRespository.findById(1L);
        // if (result.isPresent()) {

        // // Book book = result(book);

        // }
        System.out.println(book);

    }

    @Test
    public void testRead2() {
        Book book = bookRespository.findByIsbn("A101010").orElseThrow(EntityNotFoundException::new);
        System.out.println(book);
        List<Book> list = bookRespository.findByTitleContaining("파워");
        System.out.println(list);
    }

    @Test
    public void testModify() {
        Book book = bookRespository.findById(1L).orElseThrow();
        book.changePrice((35000));
        System.out.println(bookRespository.save(book));
    }

    @Test
    public void testDelete() {
        bookRespository.deleteById(10L);
    }
}
