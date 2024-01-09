package com.example.hellospringproject.domain;

import java.util.Random;

public class Hello {
    private String name;

    private String age;

    public String getAge() {
        return age;
    }

    public void setAge() {
        Random random = new Random();
        int ages = random.nextInt(100);
        this.age = Integer.toString(ages);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
