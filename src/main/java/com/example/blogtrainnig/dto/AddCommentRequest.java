package com.example.blogtrainnig.dto;

import com.example.blogtrainnig.model.Article;
import com.example.blogtrainnig.model.Comment;
import com.example.blogtrainnig.service.BlogService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddCommentRequest {

    private String body;

}
