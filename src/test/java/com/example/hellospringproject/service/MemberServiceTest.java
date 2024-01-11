package com.example.hellospringproject.service;

import com.example.hellospringproject.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
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
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복_회원_예외() {
        // given (데이터)
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when (~할 때)
        memberService.join(member1);

        // then (결과 예측)
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
    }
}