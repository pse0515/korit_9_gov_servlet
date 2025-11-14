package com.korit.servlet_study.ch11.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Subject {
    private int subjectId;
    private String subjectCode;
    private String subjectName;
    private int departmentId;
}