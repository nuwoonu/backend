package com.example.memo.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@EntityListeners(value = AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Table(name = "memotbl") // 문자열 정보 대소문자 구분안함.
@Entity // 테이블로 연결되어있음.
public class Memo {
    // 테이블(memotbl) 컬럼 : mno, memo_text, create_date, update_date
    // 클래스 필드명 == 테이블 컬럼명
    // 클래스 필드명 != 테이블 컬럼명(@Column(name=""))

    @GeneratedValue(strategy = GenerationType.IDENTITY) // 12345678 증가 될때 사용.
    @Id
    @Column(name = "mno")
    private Long id;

    @Column(nullable = false, name = "memo_text")
    private String text; // DB로 넘어갈땐 _로 바꿔진다.

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime updateDate;

    public void changeText(String text) {
        this.text = text;
    }
}
