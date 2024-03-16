package com.example.blogtrainnig.service;

import com.example.blogtrainnig.dto.AddCommentRequest;
import com.example.blogtrainnig.model.Article;
import com.example.blogtrainnig.repository.CommentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentServiceTest {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;

    @DisplayName("Service 테스트")
    @Test
    public void saveTest() {
        AddCommentRequest request = new AddCommentRequest("내용");
        commentService.save(request, 1L);
    }
}