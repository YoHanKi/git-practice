package com.example.blogtrainnig.model;

import com.example.blogtrainnig.dto.CommentResponse;
import com.example.blogtrainnig.dto.GetCommentResponse;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "body", nullable = false)
    private String body;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @Builder
    public Comment(String body, Article article) {
        this.body = body;
        this.article = article;
    }

    public CommentResponse toResponse() {
        return CommentResponse.builder().body(body).build();
    }

    public GetCommentResponse toGetResponse() {
        return GetCommentResponse.builder().id(id).body(body).createdAt(createdAt).build();
    }
}
