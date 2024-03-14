package com.example.blogtrainnig.controller;

import com.example.blogtrainnig.dto.AddArticleRequest;
import com.example.blogtrainnig.dto.ArticleResponse;
import com.example.blogtrainnig.model.Article;
import com.example.blogtrainnig.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/api/articles")
    @ResponseBody //json 형식으로 받아준다.
    public ResponseEntity<ArticleResponse> addArticle(@RequestBody AddArticleRequest request) {
        Article article = blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(article.toResponse());
    }

    @RequestMapping(value = "/api/articles", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<ArticleResponse>> showArticles() {
        List<Article> articleList = blogService.findAll();
        List<ArticleResponse> responseList = articleList.stream().map(ArticleResponse::new).toList();
        return ResponseEntity.status(HttpStatus.OK).body(responseList);
    }

    @GetMapping("/api/articles/{id}")
    @ResponseBody
    public ResponseEntity<ArticleResponse> showArticle(@PathVariable("id")Long id) {
        Article article = blogService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(article.toResponse());
    }

    @DeleteMapping("/api/articles/{id}")
    @ResponseBody
    public void deleteOneArticle(@PathVariable("id")Long id) {
        blogService.deleteById(id);
    }

    @PutMapping("api/articles/title/{id}")
    @ResponseBody
    public ResponseEntity<Article> updateOneArticleTitle(@PathVariable("id") Long id,
                                                    @RequestBody AddArticleRequest request) {
        Article updated = blogService.updateTitle(id, request);
        return ResponseEntity.ok(updated);
    }

    @PutMapping("api/articles/{id}")
    @ResponseBody
    public ResponseEntity<Article> updateOneArticle(@PathVariable("id") Long id,
                                                    @RequestBody AddArticleRequest request) {
        Article updated = blogService.update(id, request);
        return ResponseEntity.ok(updated);
    }
}
