package com.example.hellospringproject.service;

import com.example.hellospringproject.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();

    @Test
    void 회원가입() {
     // given (데이터)
        Member member = new Member();
        member.setName("spring1");

     // when (~할때)
        long saveId = memberService.join(member);

     // then (결과예측)
        Member findMember = memberService.findOne(saveId).get();
//        Assertions.assertEquals(member.getName(), findMember.getName());
        org.assertj.core.api.Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

}