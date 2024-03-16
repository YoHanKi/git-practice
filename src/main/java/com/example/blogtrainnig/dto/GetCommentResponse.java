package com.example.blogtrainnig.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class GetCommentResponse {
    private Long id;
    private String body;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @Builder
    public GetCommentResponse(Long id, String body, LocalDateTime createdAt) {
        this.id = id;
        this.body = body;
        this.createdAt = createdAt;
    }
}
