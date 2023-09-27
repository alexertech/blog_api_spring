// src/main/java/com/example/blog/repository/PostRepository.java

package com.example.blog.repository;

import com.example.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
