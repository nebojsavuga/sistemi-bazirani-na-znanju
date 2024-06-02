package com.ftn.sbnz.service.repositories;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ftn.sbnz.model.articles.Article;
import com.ftn.sbnz.model.events.Purchase;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Optional<Article> findById(Long id);

    List<Article> findAll();

    long count();
}
