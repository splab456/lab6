package com.lab1.springbootconsoleapp.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "post_details")
public class PostDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int views;

    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "post_id", unique = true)
    private Post post;

    public PostDetails() {
    }

    public PostDetails(int views, LocalDateTime createdAt) {
        this.views = views;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
