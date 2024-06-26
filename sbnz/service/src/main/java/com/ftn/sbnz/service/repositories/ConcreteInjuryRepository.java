package com.ftn.sbnz.service.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.sbnz.model.users.ConcreteInjury;

@Repository
public interface ConcreteInjuryRepository extends JpaRepository<ConcreteInjury, Long> {

    public List<ConcreteInjury> findByUserId(Long userId);
    public Optional<ConcreteInjury> findById(Long id);

    
}