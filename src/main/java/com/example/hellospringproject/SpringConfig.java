package com.example.hellospringproject;

import com.example.hellospringproject.repository.JdbcMemberRepository;
import com.example.hellospringproject.repository.JdbcTemplateMemberRepository;
import com.example.hellospringproject.repository.MemberRepository;
import com.example.hellospringproject.repository.MemoryMemberRepository;
import com.example.hellospringproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository()); // ctrl + P : 파라미터 확인 가능
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
