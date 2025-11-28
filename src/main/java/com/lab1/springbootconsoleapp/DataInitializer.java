package com.lab1.springbootconsoleapp;

import com.lab1.springbootconsoleapp.models.Author;
import com.lab1.springbootconsoleapp.models.Category;
import com.lab1.springbootconsoleapp.models.Post;
import com.lab1.springbootconsoleapp.models.PostDetails;
import com.lab1.springbootconsoleapp.repositories.AuthorRepository;
import com.lab1.springbootconsoleapp.repositories.CategoryRepository;
import com.lab1.springbootconsoleapp.repositories.PostDetailsRepository;
import com.lab1.springbootconsoleapp.repositories.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(AuthorRepository authorRepository,
                                      CategoryRepository categoryRepository,
                                      PostRepository postRepository,
                                      PostDetailsRepository detailsRepository) {
        return args -> {
            if (postRepository.count() > 0) {
                return;
            }

            Author author = new Author("Admin", "admin@example.com");
            authorRepository.save(author);

            Category catNews = new Category("News");
            Category catTech = new Category("Tech");
            categoryRepository.save(catNews);
            categoryRepository.save(catTech);

            Post p1 = new Post("First post", "Short intro", "Full text of the first post", author, catNews);
            Post p2 = new Post("Second post", "Another intro", "Full text of the second post", author, catTech);

            postRepository.save(p1);
            postRepository.save(p2);

            PostDetails d1 = new PostDetails(10, LocalDateTime.now());
            d1.setPost(p1);
            PostDetails d2 = new PostDetails(5, LocalDateTime.now());
            d2.setPost(p2);

            detailsRepository.save(d1);
            detailsRepository.save(d2);
        };
    }
}
