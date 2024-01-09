package com.example.hellospringproject.service;

import com.example.hellospringproject.domain.Member;
import com.example.hellospringproject.repository.MemberRepository;
import com.example.hellospringproject.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * ȸ������
     */
    public Long join(Member member) {
        // ���� �̸��� �ִ� �ߺ� ȸ�� X
        // Optional<Member> result = memberRepository.findbyName(member.getName()); // Ctrl+Alt+V�� ���� ���� �ڵ� ����
        // result.ifPresent(m -> {~~~})
        validateDuplicateMember(member); // �ߺ� ȸ�� ����
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m->{
                    throw new IllegalStateException("�̹� �����ϴ� ȸ���Դϴ�");
                });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}