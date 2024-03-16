package com.example.blogtrainnig.controller;

import com.example.blogtrainnig.dto.AddCommentRequest;
import com.example.blogtrainnig.dto.ArticleWithCommentsResponse;
import com.example.blogtrainnig.dto.CommentResponse;
import com.example.blogtrainnig.dto.GetCommentResponse;
import com.example.blogtrainnig.model.Article;
import com.example.blogtrainnig.model.Comment;
import com.example.blogtrainnig.service.BlogService;
import com.example.blogtrainnig.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CommentController {
    private final BlogService blogService;
    private final CommentService commentService;

    public CommentController(BlogService blogService, CommentService commentService) {
        this.blogService = blogService;
        this.commentService = commentService;
    }

    @PostMapping("/comments/{articleId}")
    @ResponseBody
    public ResponseEntity<CommentResponse> addComment(@PathVariable("articleId")Long articleId,
                                                      @RequestBody AddCommentRequest request) {
        Comment comment = commentService.save(request, articleId);
        return ResponseEntity.status(HttpStatus.OK).body(comment.toResponse());
    }

    @GetMapping("/comments/{articleId}/{commentId}")
    @ResponseBody
    public ResponseEntity<CommentResponse> getComment(@PathVariable("articleId")Long articleId,
                                                      @PathVariable("commentId")Long id) {
        Comment comment = commentService.findById(articleId, id);
        return ResponseEntity.status(HttpStatus.OK).body(comment.toResponse());
    }

    @GetMapping("/comments/{articleId}")
    @ResponseBody
    public ResponseEntity<ArticleWithCommentsResponse> getComments(@PathVariable("articleId")Long articleId) {
        Article article = blogService.findById(articleId);
        ArticleWithCommentsResponse response =article.toACResponse();
        List<GetCommentResponse> list = article.getComments().stream().map(comment -> comment.toGetResponse()).toList();
        response.setComments(list);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
