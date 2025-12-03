package com.example.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.book.dto.BookDTO;
import com.example.book.entity.constant.Book;
import com.example.book.repository.BookRespository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRespository bookRepository;
    private final ModelMapper mapper;

    public Long create(BookDTO bookDTO) {
        // Book book = mapper.map(bookDTO, Book.class);
        return bookRepository.save(mapper.map(bookDTO, Book.class)).getId(); // id를 리턴한다
    }

    public List<BookDTO> readTitle(String title) {
        List<Book> result = bookRepository.findByTitleContaining((title));

        // List<Book> => List<BookDTO> 변경후 리턴
        // List<BookDTO> list = new ArrayList<>();
        // result.forEach(book -> {
        // list.add(mapper.map(book, BookDTO.class));
        // });

        return result.stream().map(book -> mapper.map(book, BookDTO.class)).collect(Collectors.toList());
    }

    public BookDTO readIsbn(String isbn) {
        Book book = bookRepository.findByIsbn(isbn).orElseThrow();

        // List<Book> => List<BookDTO> 변경후 리턴
        return mapper.map(book, BookDTO.class);
    }

    public BookDTO readId(Long id) {
        Book book = bookRepository.findById(id).orElseThrow();

        // List<Book> => List<BookDTO> 변경후 리턴
        return mapper.map(book, BookDTO.class);
    }

    public Long update(BookDTO upDto) // 받아낼게 두개이상이면 dto를 사용한다.
    {
        Book book = bookRepository.findById(upDto.getId()).orElseThrow();
        book.changePrice(upDto.getPrice());
        return bookRepository.save(book).getId();
        // 가격 업데이트
    }

    public void delete(Long id) 
    {
        bookRepository.deleteById(id);
    }
}
