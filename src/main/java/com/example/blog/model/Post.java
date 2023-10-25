// src/main/java/com/example/blog/model/Post.java

package com.example.blog.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Title cannot be empty.")
    private String title;
    @NotBlank(message = "Body cannot be empty.")
    private String body;
    private int views;

    // Constructors, Getters, and Setters omitted for brevity.
    // Override equals and hashCode methods.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
