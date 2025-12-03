package com.example.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student.entity.Student;

//DAO 역할
// 기본적인 CRUD 메소드는 이미 정의되어 있음
// entity 하나에 repository 하나 만든다.
// repository는 받아 내린다. id card랑 time card 를 내려 받는다
public interface StudentRepository extends JpaRepository<Student, Long> // <클래스명, @Id 어노테이션의 타입을 가져온다.
{

}