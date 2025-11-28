package com.lab1.springbootconsoleapp;

import com.lab1.springbootconsoleapp.models.Author;
import com.lab1.springbootconsoleapp.models.Category;
import com.lab1.springbootconsoleapp.models.Post;
import com.lab1.springbootconsoleapp.repositories.AuthorRepository;
import com.lab1.springbootconsoleapp.repositories.CategoryRepository;
import com.lab1.springbootconsoleapp.repositories.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void saveAndLoadPost() {
        Author author = new Author("Test Author", "test@example.com");
        authorRepository.save(author);

        Category category = new Category("Test Category");
        categoryRepository.save(category);

        Post post = new Post("Test title", "Anons", "Full text", author, category);
        postRepository.save(post);

        List<Post> all = postRepository.findAll();
        assertThat(all).isNotEmpty();
        assertThat(all.get(0).getTitle()).isEqualTo("Test title");
    }
}
