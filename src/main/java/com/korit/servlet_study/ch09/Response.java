package com.korit.servlet_study.ch09;

import lombok.*;

@Data
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Response {
    private String message;
}
