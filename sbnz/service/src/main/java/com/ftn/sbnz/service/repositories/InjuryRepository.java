package com.ftn.sbnz.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.sbnz.model.users.Injury;

@Repository
public interface InjuryRepository extends JpaRepository<Injury, Long> {
}