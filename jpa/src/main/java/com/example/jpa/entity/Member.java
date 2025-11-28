package com.example.jpa.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.example.jpa.entity.constant.RoleType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Table(name = "membertbl")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Member {
    // 아이디 이름(필수) 나이(필수) 역할(MEMBER,ADMIN) 가입일자 수정일자 자기소개

    @GeneratedValue(strategy = GenerationType.IDENTITY) // 12345 증감치 줄때만샤용
    @Id
    private Long Id;

    @Column(unique = true, nullable = false)
    private String userId;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleType role;

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime updateDate;

    @Column(length = 2000)
    // @Lob
    private String description;

    public void changeRole(RoleType role) {
        this.role = role;
    }
}
