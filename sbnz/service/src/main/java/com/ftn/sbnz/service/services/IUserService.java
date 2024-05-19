package com.ftn.sbnz.service.services;

import java.util.Set;

import javax.servlet.http.HttpSession;

import com.ftn.sbnz.model.users.User;
import com.ftn.sbnz.service.controllers.dtos.ArticleDTO;
import com.ftn.sbnz.service.controllers.dtos.RegisterDTO;

public interface IUserService {
    User getByEmailAndPassword(String email, String password);

    User getByEmail(String email);

    User register(RegisterDTO registerDTO);

    String addFavoriteArticle(Long id, Long userId);

    Set<ArticleDTO> getFavoriteArticles(Long userId);
}
