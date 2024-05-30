package com.ftn.sbnz.service.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ftn.sbnz.model.articles.Article;
import com.ftn.sbnz.model.users.ConcreteInjury;
import com.ftn.sbnz.model.users.Injury;
import com.ftn.sbnz.model.users.Role;
import com.ftn.sbnz.model.users.User;
import com.ftn.sbnz.service.controllers.dtos.ArticleDTO;
import com.ftn.sbnz.service.controllers.dtos.ConcreteInjuryDTO;
import com.ftn.sbnz.service.controllers.dtos.RegisterDTO;
import com.ftn.sbnz.service.controllers.dtos.UserDTO;
import com.ftn.sbnz.service.exceptions.BadCredentialsException;
import com.ftn.sbnz.service.exceptions.BadRequestException;
import com.ftn.sbnz.service.exceptions.NotFoundException;
import com.ftn.sbnz.service.exceptions.UnauthorizedException;
import com.ftn.sbnz.service.repositories.ArticleRepository;
import com.ftn.sbnz.service.repositories.ConcreteInjuryRepository;
import com.ftn.sbnz.service.repositories.InjuryRepository;
import com.ftn.sbnz.service.repositories.UserRepository;

@Service
public class UserService implements IUserService {

    private UserRepository userRepository;
    private ArticleRepository articleRepository;
    private InjuryRepository injuryRepository;
    private PasswordEncoder passwordEncoder;
    private ConcreteInjuryRepository concreteInjuryRepository;

    @Autowired
    public UserService(UserRepository userRepository, ArticleRepository articleRepository, InjuryRepository injuryRepository,
            PasswordEncoder passwordEncoder, ConcreteInjuryRepository concreteInjuryRepository) {
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
        this.injuryRepository = injuryRepository;
        this.passwordEncoder = passwordEncoder;
        this.concreteInjuryRepository = concreteInjuryRepository;
    }

    @Override
    public User getByEmailAndPassword(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        return user;
    }

    @Override
    public User register(RegisterDTO registerDTO) {
        User existingUser = userRepository.findByEmail(registerDTO.email);
        if (existingUser != null) {
            throw new BadCredentialsException("User with the given email address exists.");
        }
        if (!registerDTO.password.equals(registerDTO.repeatPassword) ) {
            throw new BadCredentialsException("Password and repeat password must be same.");
        }
        User user = new User(registerDTO.email,
                this.passwordEncoder.encode(registerDTO.password),
                registerDTO.firstName,
                registerDTO.lastName,
                Role.User,
                registerDTO.gender,
                registerDTO.age,
                registerDTO.height);
        user = userRepository.save(user);
        return user;
    }

    @Override
    public String addFavoriteArticle(Long id, Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new UnauthorizedException("Not authorized.");
        }

        for (Article article : user.get().getFavoriteArticles()) {
            if (article.getId() == id) {
                throw new BadCredentialsException("Article is already in favorite list.");
            }
        }

        Optional<Article> article = this.articleRepository.findById(id);
        if (article.isEmpty()) {
            throw new NotFoundException("Article with that id does not exist.");
        }

        user.get().addFavoriteArticle(article.get());
        userRepository.save(user.get());
        return article.get().getName();
    }

    @Override
    public Set<ArticleDTO> getFavoriteArticles(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new UnauthorizedException("Not authorized.");
        }
        Set<Article> articles = user.get().getFavoriteArticles();
        Set<ArticleDTO> dtos = new HashSet<>();
        for (Article article : articles) {
            dtos.add(new ArticleDTO(article.getId(),
                    article.getName(),
                    article.getPrice(),
                    article.getBrandName(),
                    article.getClassName()));
        }
        return dtos;
    }

    @Override
    public User getByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return user;
    }

    @Override
    public UserDTO getById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new NotFoundException("User with that id does not exist.");
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setAge(user.get().getAge());
        userDTO.setGender(user.get().getGender());
        userDTO.setHeight(user.get().getHeight());
        return userDTO;
    }

    @Override
    public User edit(RegisterDTO registerDTO, long userId) {
        
        Optional<User> existingUser = userRepository.findById(userId);
        
        if (!registerDTO.password.equals(registerDTO.repeatPassword) ) {
            throw new BadCredentialsException("Password and repeat password must be same.");
        }
        existingUser.get().setFirstName(registerDTO.firstName);
        existingUser.get().setHeight(registerDTO.height);
        existingUser.get().setLastName(registerDTO.lastName);
        existingUser.get().setAge(registerDTO.age);
        existingUser.get().setGender(registerDTO.gender);
        existingUser.get().setPassword(this.passwordEncoder.encode(registerDTO.password));
        
        
        User user = userRepository.save(existingUser.get());
        return user;
    }

    @Override
    public String addInjury(ConcreteInjuryDTO injuryDTO, Long userId) {
        Optional<User> user = userRepository.findById(userId);
        Injury injury = injuryRepository.findByName(injuryDTO.getInjury());
        if(injury == null){
            throw new BadRequestException("Injury with that name does not exist");
        }
        ConcreteInjury concreteInjury= new ConcreteInjury();
        concreteInjury.setExecutionTime(injuryDTO.getExecutionTime());
        concreteInjury.setUser(user.get());
        concreteInjury.setInjury(injury);
        this.concreteInjuryRepository.save(concreteInjury);

        return "Concrete injury added.";
    }
}
