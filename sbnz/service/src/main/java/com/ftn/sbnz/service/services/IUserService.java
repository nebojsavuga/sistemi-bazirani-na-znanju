package com.ftn.sbnz.service.services;

import java.util.Set;


import com.ftn.sbnz.model.users.User;
import com.ftn.sbnz.service.controllers.dtos.ArticleDTO;
import com.ftn.sbnz.service.controllers.dtos.RegisterDTO;
import com.ftn.sbnz.service.controllers.dtos.UserDTO;

public interface IUserService {
    User getByEmailAndPassword(String email, String password);

    User getByEmail(String email);

    User register(RegisterDTO registerDTO);
    UserDTO getById(Long id);

    String addFavoriteArticle(Long id, Long userId);

    Set<ArticleDTO> getFavoriteArticles(Long userId);
}
