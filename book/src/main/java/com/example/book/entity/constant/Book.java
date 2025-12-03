package com.example.book.entity.constant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "booktbl")
public class Book {
    @GeneratedValue
    @Id
    private long id;

    @Column(unique = true)
    private String isbn;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false)
    private String author;

    public void changePrice(int price) {
        this.price = price;
    }

}
