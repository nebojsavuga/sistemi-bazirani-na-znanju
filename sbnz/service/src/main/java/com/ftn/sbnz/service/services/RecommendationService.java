package com.ftn.sbnz.service.services;

import java.util.HashSet;
import java.util.Set;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.ftn.sbnz.service.controllers.dtos.Filters;
import com.ftn.sbnz.service.controllers.dtos.RecommendedArticleDTO;

public class RecommendationService implements IRecommendationService {

	private final KieContainer kieContainer;
    private Set<RecommendedArticleDTO> recommendations = new HashSet<>();

    @Autowired
    public RecommendationService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    @Override
    public Set<RecommendedArticleDTO> getRecommendations(Filters filters) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("recommendations", recommendations);
        kieSession.insert(filters);
        kieSession.fireAllRules();
        kieSession.dispose();
        return recommendations;
    }
}
