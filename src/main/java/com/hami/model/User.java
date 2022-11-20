package com.hami.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Integer id;
    private String name;
    @Column(unique = true)
    private String username;
    private String password;
    private String email;
    @Column(columnDefinition = "text")
    private String bio;
    private Date createDate;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UserRole> userRoles = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> post;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> linkedPost;

    public User() {
    }

    public User(Integer id, String name, String username, String password, String email, String bio, Date createDate, Set<UserRole> userRoles, List<Post> post, List<Post> linkedPost) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.bio = bio;
        this.createDate = createDate;
        this.userRoles = userRoles;
        this.post = post;
        this.linkedPost = linkedPost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }

    public List<Post> getLinkedPost() {
        return linkedPost;
    }

    public void setLinkedPost(List<Post> linkedPost) {
        this.linkedPost = linkedPost;
    }
}
