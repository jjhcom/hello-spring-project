package com.example.hellospringproject;

import com.example.hellospringproject.repository.MemberRepository;
import com.example.hellospringproject.repository.MemoryMemberRepository;
import com.example.hellospringproject.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
