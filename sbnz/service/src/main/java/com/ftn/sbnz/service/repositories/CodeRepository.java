package com.ftn.sbnz.service.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.sbnz.model.Code;

@Repository
public interface CodeRepository extends JpaRepository<Code, Long> {
    Optional<Code> findById(Long id);
    List<Code> findByUserIdAndIsUsed(Long userId, boolean isUsed);
} 
