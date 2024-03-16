package com.example.blogtrainnig.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentResponse {

    private String body;

    @Builder
    public CommentResponse(String body) {
        this.body = body;
    }
}
