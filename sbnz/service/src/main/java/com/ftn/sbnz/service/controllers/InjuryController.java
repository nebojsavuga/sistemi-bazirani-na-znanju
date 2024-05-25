package com.ftn.sbnz.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.sbnz.model.users.Injury;
import com.ftn.sbnz.service.repositories.InjuryRepository;

@RestController
@RequestMapping(value = "api/injuries")
public class InjuryController {
    private InjuryRepository injuryRepository;

    @Autowired
    public InjuryController(InjuryRepository injuryRepository) {
        this.injuryRepository = injuryRepository;
    }

    @GetMapping()
    public ResponseEntity<List<Injury>> getAll() {
        return new ResponseEntity<>(this.injuryRepository.findAll(),
                HttpStatus.OK);
    }
}