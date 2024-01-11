package com.example.hellospringproject.service;

import com.example.hellospringproject.domain.Member;
import com.example.hellospringproject.repository.MemberRepository;
import com.example.hellospringproject.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원가입
     */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원 X
        // Optional<Member> result = memberRepository.findbyName(member.getName()); // Ctrl+Alt+V로 리턴 변수 자동 생성
        // result.ifPresent(m -> {~~~})
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}