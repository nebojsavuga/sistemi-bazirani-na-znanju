package com.ftn.sbnz.service.repositories;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.sbnz.model.articles.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long>{
    
    Optional<Rating> findByUserIdAndArticleId(Long userId, Long articleId);
    Set<Rating> findByUserId(Long userId);
}
