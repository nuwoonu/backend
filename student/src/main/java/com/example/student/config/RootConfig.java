package com.example.student.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 스프링 환경설정 파일.
public class RootConfig {
    @Bean // 객체 생성해서 스프링 컨테이너가 관리해줘.
    public ModelMapper getMapper() {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true) // 필드명 같은 경우 매핑
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE) // getter setter 없이도
                                                                                               // private 필드 접근 가능하도록
                                                                                               // 허용하는 코드.
                .setMatchingStrategy(MatchingStrategies.LOOSE); // username, user_name : 비슷한 이름이면 알아서 매칭
        return modelMapper;
    }
}
