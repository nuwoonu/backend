package com.example.student.service;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test; // 테스트를 할 수 있도록 도와준다. Java 쪽에서 지원해주는것.
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.example.student.dto.StudentDTO;
import com.example.student.entity.Student;
import com.example.student.entity.constant.Grade;

@Disabled
@SpringBootTest
public class StudentServiceTest {
    @Autowired // 주입하는 의미
    private StudentService studentService;

    @Test
    @Commit // 트랜잭션을 커밋하여 실제 DB에 저장
    public void testInsert() {
        StudentDTO dto = StudentDTO.builder()
                .name("홍길동")
                .gender("M")
                .addr("종로")
                .grade(Grade.FRESHMAN)
                .build();

        System.out.println(studentService.insert(dto));
    }

    @Test
    public void testRead() {
        System.out.println(studentService.read(2L));
    }

    @Test
    public void testReadAll() {
        List<StudentDTO> list = studentService.readAll();

        for (StudentDTO studentDTO : list) {
            System.out.println(studentDTO);
        }
    }

    @Test
    public void testUpdate() {
        StudentDTO dto = StudentDTO.builder()
                .id(21L)
                .name("홍길동")
                .grade(Grade.JUNIOR)
                .build();

        System.out.println(studentService.update(dto));

    }

    @Test
    public void testDelete() {
        studentService.delete(22L);
    }
}
