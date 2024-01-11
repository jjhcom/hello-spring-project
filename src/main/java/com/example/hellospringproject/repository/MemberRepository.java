package com.example.hellospringproject.repository;

import com.example.hellospringproject.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    // 저장 기능, 아이디로 조회 기능,
    // 이름으로 조회 기능, 전체 조회
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

}
