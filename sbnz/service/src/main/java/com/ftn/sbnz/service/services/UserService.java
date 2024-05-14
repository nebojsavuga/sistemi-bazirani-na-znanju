package com.ftn.sbnz.service.services;

import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.sbnz.model.articles.Article;
import com.ftn.sbnz.model.users.Role;
import com.ftn.sbnz.model.users.User;
import com.ftn.sbnz.service.controllers.RegisterDTO;
import com.ftn.sbnz.service.exceptions.NotFoundException;
import com.ftn.sbnz.service.exceptions.UnauthorizedException;
import com.ftn.sbnz.service.exceptions.UserAlreadyExistsException;
import com.ftn.sbnz.service.repositories.ArticleRepository;
import com.ftn.sbnz.service.repositories.UserRepository;

@Service
public class UserService implements IUserService{

    private UserRepository userRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public UserService(UserRepository userRepository, ArticleRepository articleRepository) {
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public User getByEmailAndPassword(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        return user;
    }

    @Override
    public User register(RegisterDTO registerDTO) {
        User user = new User(registerDTO.email, registerDTO.password, registerDTO.firstName, registerDTO.lastName, Role.User, registerDTO.gender);
        user = userRepository.save(user);
        return user;
    }

    @Override
    public Article addFavoriteArticle(Long id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null){
            throw new UnauthorizedException("Not authorized!");
        }
        Optional<Article> article = this.articleRepository.findById(id);
        if (article.isEmpty()){
            throw new NotFoundException("Article with that id does not exist.");
        }
        
        Set<Article> userArticles = user.getFavoriteArticles();
        userArticles.add(article.get());
        user.setFavoriteArticles(userArticles);
        userRepository.save(user);
        return article.get();
        
    }
    
}
