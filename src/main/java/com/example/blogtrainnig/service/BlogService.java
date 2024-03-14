package com.example.blogtrainnig.service;

import com.example.blogtrainnig.dto.AddArticleRequest;
import com.example.blogtrainnig.model.Article;
import com.example.blogtrainnig.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not fount id : " + id));
    }

    public void deleteById(Long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(Long id, AddArticleRequest request) {
        Article article = findById(id);
        article.update(request.getTitle(), request.getContent());
        return article;
    }

    @Transactional
    public Article updateTitle(Long id, AddArticleRequest request) {
        Article article = findById(id);
        blogRepository.updateTitle(id, request.getTitle());
        return article;
    }
}
