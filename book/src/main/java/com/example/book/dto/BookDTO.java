package com.example.book.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder

@Data
// @Getter
// @Setter
// @ToString
public class BookDTO {

    private Long id;
    private String isbn;
    private String title;
    private int price;
    private String author;
}
