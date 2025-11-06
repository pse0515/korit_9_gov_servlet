package com.korit.servlet_study.ch08;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Response {
    private String message;
}
