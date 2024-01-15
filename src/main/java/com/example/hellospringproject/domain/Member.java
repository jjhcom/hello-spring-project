package com.example.hellospringproject.domain;

import jakarta.persistence.*;

@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

//    public String getNickname() {
//        return nickname;
//    }

//    public void setNickname(String nickname) {
//        this.nickname = nickname;
//    }
//
//    private String nickname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
