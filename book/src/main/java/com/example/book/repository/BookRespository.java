package com.example.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.book.entity.constant.Book;
import java.util.List;
import java.util.Optional;

public interface BookRespository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn(String isbn); // =의 의미만 갖고있다 where isbn = 'A1000' 유니크라서 List로 나올일 없기에 Optional로 바꾼다.

    List<Book> findByTitleContaining(String title); // = where title = '자바'
}
