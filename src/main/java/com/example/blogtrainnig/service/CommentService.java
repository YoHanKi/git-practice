package com.example.blogtrainnig.service;

import com.example.blogtrainnig.dto.AddCommentRequest;
import com.example.blogtrainnig.model.Article;
import com.example.blogtrainnig.model.Comment;
import com.example.blogtrainnig.repository.BlogRepository;
import com.example.blogtrainnig.repository.CommentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    private BlogService blogService;

    public CommentService(CommentRepository commentRepository, BlogService blogService) {
        this.commentRepository = commentRepository;
        this.blogService = blogService;
    }

    public Comment save(AddCommentRequest request, Long articleId) {

        Comment comment = Comment.builder()
                .body(request.getBody())
                .article(blogService.findById(articleId))
                .build();

        return commentRepository.save(comment);
    }

    public Comment findById(Long articleId, Long id) {
        Article article = blogService.findById(articleId);
        Comment commentF = new Comment();
        for (Comment comment : article.getComments()) {
            if(comment.getId() == id) commentF = comment;
        }
        return commentF;
    }
    public List<Comment> findAll(Long articleId) {
        Article article = blogService.findById(articleId);
        return article.getComments();
    }
}
