package com.example.blogtrainnig.repository;

import com.example.blogtrainnig.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Article, Long> {
    //JPQL
    @Modifying
    @Query("UPDATE Article SET title = :title WHERE id = :id")
    void updateTitle(Long id, String title);
}
