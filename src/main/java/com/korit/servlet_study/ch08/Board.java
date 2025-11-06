package com.korit.servlet_study.ch08;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Board {
    private String title;
    private String content;
    private String writer;
}
