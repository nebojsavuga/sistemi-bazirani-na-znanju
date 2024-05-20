package com.ftn.sbnz.model.users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ftn.sbnz.model.Code;
import com.ftn.sbnz.model.articles.Article;
import com.ftn.sbnz.model.articles.Rating;
import com.ftn.sbnz.model.events.Purchase;

@Entity
@Table(name = "Users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column
    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    // Height in cm
    @Column
    private float height;

    @OneToMany(mappedBy = "user")
    private Set<ConcreteInjury> injuries = new HashSet<ConcreteInjury>();

    @OneToMany(mappedBy = "user")
    private Set<Rating> ratings = new HashSet<Rating>();

    @OneToMany
    private Set<Article> favoriteArticles = new HashSet<Article>();

    @OneToMany
    private Set<Article> nonRecommendedArticles = new HashSet<Article>();

    @OneToMany(mappedBy = "user")
    private Set<Purchase> purchases = new HashSet<Purchase>();

    @OneToMany(mappedBy = "user")
    private Set<Code> codes = new HashSet<Code>();

    @Override
    public String toString() {
        return "User [id=" + id + ", email=" + email + ", password=" + password + ", firstName=" + firstName
                + ", lastName=" + lastName + ", role=" + role + "]";
    }

    public User() {
    }

    public User(Long id, String email, String password, String firstName, String lastName, Role role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public User(String email, String password, String firstName, String lastName, Role role, Gender gender) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.gender = gender;
    }

    public void addRating(Rating rating) {
        this.ratings.add(rating);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Set<ConcreteInjury> getInjuries() {
        return injuries;
    }

    public void setInjuries(Set<ConcreteInjury> injuries) {
        this.injuries = injuries;
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }

    public Set<Article> getFavoriteArticles() {
        return favoriteArticles;
    }

    public void setFavoriteArticles(Set<Article> favoriteArticles) {
        this.favoriteArticles = favoriteArticles;
    }

    public void addFavoriteArticle(Article favoriteArticle) {
        this.favoriteArticles.add(favoriteArticle);
    }

    public Set<Article> getNonRecommendedArticles() {
        return nonRecommendedArticles;
    }

    public void setNonRecommendedArticles(Set<Article> nonRecommendedArticles) {
        this.nonRecommendedArticles = nonRecommendedArticles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role.toString());
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(authority);
        return authorities;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
