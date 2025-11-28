package com.lab1.springbootconsoleapp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String anons;

    @Column(name = "full_text", columnDefinition = "TEXT")
    private String fullText;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private PostDetails details;

    public Post() {
    }

    public Post(String title, String anons, String fullText, Author author, Category category) {
        this.title = title;
        this.anons = anons;
        this.fullText = fullText;
        this.author = author;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public PostDetails getDetails() {
        return details;
    }

    public void setDetails(PostDetails details) {
        this.details = details;
        if (details != null) {
            details.setPost(this);
        }
    }
}
