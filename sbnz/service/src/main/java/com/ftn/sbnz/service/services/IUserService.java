package com.ftn.sbnz.service.services;

import java.util.List;
import java.util.Set;

import com.ftn.sbnz.model.users.ConcreteInjury;
import com.ftn.sbnz.model.users.User;
import com.ftn.sbnz.service.controllers.dtos.ArticleDTO;
import com.ftn.sbnz.service.controllers.dtos.CodeDTO;
import com.ftn.sbnz.service.controllers.dtos.ConcreteInjuryDTO;
import com.ftn.sbnz.service.controllers.dtos.LoggedUserDTO;
import com.ftn.sbnz.service.controllers.dtos.LoggedUserInjuryDTO;
import com.ftn.sbnz.service.controllers.dtos.RegisterDTO;
import com.ftn.sbnz.service.controllers.dtos.UserDTO;

public interface IUserService {
    User getByEmailAndPassword(String email, String password);

    User getByEmail(String email);

    User register(RegisterDTO registerDTO);
    UserDTO getById(Long id);

    String addFavoriteArticle(Long id, Long userId);

    Set<ArticleDTO> getFavoriteArticles(Long userId);

    User edit(RegisterDTO registerDTO, long userId);

    String addInjury(ConcreteInjuryDTO injuryDTO, Long userId);

    LoggedUserDTO getLoggedUserById(Long userId);

    List<LoggedUserInjuryDTO> getLoggedUserInjuries(Long userId);

    ConcreteInjury deleteUserInjury(Long injuryId, Long userId);

    boolean deleteFavoriteArticle(Long articleId, Long userId);

    List<CodeDTO> getCodes(Long userId);
}
