package com.korit.servlet_study.ch09;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student {
    private String name;
    private int age;
    private String address;
    private String school;
}
