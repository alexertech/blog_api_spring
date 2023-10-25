// src/test/java/com/example/blog/controller/PostControllerTest.java

package com.example.blog.controller;

import com.example.blog.model.Post;
import com.example.blog.repository.PostRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostRepository postRepository;

    @Test
    void getAllPosts_returnsOk() throws Exception {
        mockMvc.perform(get("/posts"))
                .andExpect(status().isOk());
    }

    @Test
    void createPost_returnsPost() throws Exception {
        Post post = new Post();
        post.setTitle("Test Title");
        post.setBody("Test Body");

        when(postRepository.save(post)).thenReturn(post);

        mockMvc.perform(post("/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(post)))
                .andExpect(status().isOk());
    }

    @Test
    void getPostById_returnsPost() throws Exception {
        Post post = new Post();
        post.setId(1L);
        post.setTitle("Test Title");
        post.setBody("Test Body");

        when(postRepository.findById(1L)).thenReturn(Optional.of(post));

        mockMvc.perform(get("/posts/1"))
                .andExpect(status().isOk());
    }

    @Test
    void createPost_emptyTitle_returnsBadRequest() throws Exception {
        Post post = new Post();
        post.setTitle("");
        post.setBody("Test Body");

        mockMvc.perform(post("/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(post)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void createPost_emptyBody_returnsBadRequest() throws Exception {
        Post post = new Post();
        post.setTitle("Test Title");
        post.setBody("");

        mockMvc.perform(post("/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(post)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void updatePost_returnsOk() throws Exception {
        Post post = new Post();
        post.setId(1L);
        post.setTitle("Updated Title");
        post.setBody("Updated Body");

        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(postRepository.save(post)).thenReturn(post);

        mockMvc.perform(put("/posts/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(post)))
                .andExpect(status().isOk());
    }

    @Test
    void deletePost_returnsOk() throws Exception {
        Post post = new Post();
        post.setId(1L);
        post.setTitle("Test Title");
        post.setBody("Test Body");

        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        doNothing().when(postRepository).delete(post);

        mockMvc.perform(delete("/posts/1"))
                .andExpect(status().isOk());
    }
}
