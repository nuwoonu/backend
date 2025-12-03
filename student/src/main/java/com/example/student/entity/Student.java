package com.example.student.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.student.entity.constant.Grade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EntityListeners(value = AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Builder
@Table(name = "stutbl")
@Entity // 이 클래스는 테이블과 연동되어있음.
public class Student {
    // @GeneratedValue(strategy = GenerationType.AUTO) == : deafult (Hibernate 가
    // 자동으로 생성)

    @GeneratedValue(strategy = GenerationType.IDENTITY) // MySQL(auto_increment),
    // Oralce(sequence)
    // @SequenceGenerator(name = "stu_seq_gen", sequenceName = "stu_seq",
    // allocationSize = 1)
    // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
    // "stu_seq_gen")
    @Id
    private Long id;

    // @Column(name = "sname", length = 50, nullable = false, unique = true) //
    // sname varchar(50) not null,
    @Column(columnDefinition = "varchar(50) not null") // unique 직접 넣는것.
    private String name;

    @Column
    private String addr;

    @Column(columnDefinition = "varchar(1) CONSTRAINT chk_gender CHECK (gender IN('M','F'))")
    private String gender;

    // grade => FRESHMAN, SOPHOMORE, JUNIOR, SENIOR
    @Enumerated(EnumType.STRING) // 기본값은 숫자인 0 부터 시작.
    @Column
    private Grade grade;

    @CreatedDate
    // insert시 자동으로 일자 삽입하고 싶을경우
    private LocalDateTime createDateTime; // create_date_time1 datetime(6),

    @LastModifiedDate
    private LocalDateTime updateDateTime;

    public void changeName(String name) {
        this.name = name;
    }

    public void changeGrade(Grade grade) {
        this.grade = grade;
    }
}
