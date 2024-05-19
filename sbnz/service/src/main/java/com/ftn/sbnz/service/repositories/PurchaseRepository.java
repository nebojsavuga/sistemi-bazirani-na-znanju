package com.ftn.sbnz.service.repositories;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ftn.sbnz.model.events.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    Page<Purchase> findAll(Pageable pageable);

    Page<Purchase> findByUserId(Long userId);

    @Query("SELECT p FROM Purchase p WHERE TYPE(p.article) = :type")
    Set<Purchase> findByArticleType(Class<?> type);

    long count();
}
