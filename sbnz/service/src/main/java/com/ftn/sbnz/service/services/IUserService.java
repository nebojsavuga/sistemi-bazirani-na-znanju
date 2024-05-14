package com.ftn.sbnz.service.services;

import java.util.Set;

import javax.servlet.http.HttpSession;

import com.ftn.sbnz.model.DTO.RatingDTO;
import com.ftn.sbnz.model.articles.Article;
import com.ftn.sbnz.model.articles.Rating;
import com.ftn.sbnz.model.users.User;
import com.ftn.sbnz.service.controllers.RegisterDTO;

public interface IUserService {
    
    User getByEmailAndPassword(String email, String password);

    User register(RegisterDTO registerDTO);

    Article addFavoriteArticle(Long id, HttpSession session);

    Set<Article> getFavoriteArticles(HttpSession session);

    Rating rateArticle(RatingDTO ratingDTO, HttpSession session);
}
