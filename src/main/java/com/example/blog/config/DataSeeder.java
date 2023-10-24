package com.example.blog.config;

import com.example.blog.model.Post;
import com.example.blog.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class DataSeeder {

    @Bean
    public CommandLineRunner initData(PostRepository postRepository) {
        return args -> {
            // Check if database is empty
            if (postRepository.count() == 0) {
                Random random = new Random();

                // Seed 5 sample posts
                for (int i = 0; i < 5; i++) {
                    Post post = new Post();
                    post.setTitle("Sample Post " + (i + 1));
                    post.setBody("This is a sample post content for post " + (i + 1));
                    // post.setReadingTime(random.nextInt(5) + 1);
                    postRepository.save(post);
                }
            }
        };
    }
}
