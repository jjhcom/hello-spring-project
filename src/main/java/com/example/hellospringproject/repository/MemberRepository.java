package com.example.hellospringproject.repository;

import com.example.hellospringproject.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    // ���� ���, ���̵�� ��ȸ ���,
    // �̸����� ��ȸ ���, ��ü ��ȸ
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

}
