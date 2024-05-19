package com.ftn.sbnz.service.services;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.sbnz.model.DTO.RatingDTO;
import com.ftn.sbnz.model.articles.Article;
import com.ftn.sbnz.model.articles.Rating;
import com.ftn.sbnz.model.users.Role;
import com.ftn.sbnz.model.users.User;
import com.ftn.sbnz.service.controllers.dtos.ArticleDTO;
import com.ftn.sbnz.service.controllers.dtos.RegisterDTO;
import com.ftn.sbnz.service.exceptions.BadCredentialsException;
import com.ftn.sbnz.service.exceptions.NotFoundException;
import com.ftn.sbnz.service.exceptions.UnauthorizedException;
import com.ftn.sbnz.service.repositories.ArticleRepository;
import com.ftn.sbnz.service.repositories.RatingRepository;
import com.ftn.sbnz.service.repositories.UserRepository;

@Service
public class UserService implements IUserService {

    private UserRepository userRepository;
    private ArticleRepository articleRepository;
    private RatingRepository ratingRepository;

    @Autowired
    public UserService(UserRepository userRepository, ArticleRepository articleRepository,
            RatingRepository ratingRepository) {
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
        this.ratingRepository = ratingRepository;
    }

    @Override
    public User getByEmailAndPassword(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        return user;
    }

    @Override
    public User register(RegisterDTO registerDTO) {
        User user = new User(registerDTO.email, registerDTO.password, registerDTO.firstName, registerDTO.lastName,
                Role.User, registerDTO.gender);
        user = userRepository.save(user);
        return user;
    }

    @Override
    public String addFavoriteArticle(Long id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            throw new UnauthorizedException("Not authorized.");
        }

        for (Article article : user.getFavoriteArticles()) {
            if (article.getId() == id) {
                throw new BadCredentialsException("Article is already in favorite list.");
            }
        }

        Optional<Article> article = this.articleRepository.findById(id);
        if (article.isEmpty()) {
            throw new NotFoundException("Article with that id does not exist.");
        }

        user.addFavoriteArticle(article.get());
        userRepository.save(user);
        return article.get().getName();
    }

    @Override
    public Set<ArticleDTO> getFavoriteArticles(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            throw new UnauthorizedException("Not authorized!");
        }
        Set<Article> articles = user.getFavoriteArticles();
        Set<ArticleDTO> dtos = new HashSet<>();
        for(Article article : articles){
            dtos.add(new ArticleDTO(article.getId(),
            article.getName(),
            article.getPrice(),
            article.getBrandName(),
            ""));
        }
        return dtos;
    }

    @Override
    public RatingDTO rateArticle(RatingDTO ratingDTO, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            throw new UnauthorizedException("Not authorized!");
        }
        Optional<Article> article = this.articleRepository.findById(ratingDTO.getArticleId());
        if (article.isEmpty()) {
            throw new NotFoundException("Article with that id does not exist.");
        }
        Optional<Rating> existingRating = this.ratingRepository
                .findByUserIdAndArticleId(user.getId(), ratingDTO.getArticleId());
        if (existingRating.isPresent()) {
            existingRating.get().setRating(ratingDTO.getRating());
            existingRating.get().setTimestamp(LocalDateTime.now());
            this.ratingRepository.save(existingRating.get());
            return ratingDTO;
        }

        Rating rating = new Rating();
        rating.setArticle(article.get());
        rating.setRating(ratingDTO.getRating());
        rating.setTimestamp(LocalDateTime.now());
        rating.setUser(user);

        this.ratingRepository.save(rating);
        return ratingDTO;
    }
}
