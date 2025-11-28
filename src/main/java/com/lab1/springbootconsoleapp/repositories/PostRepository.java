package com.lab1.springbootconsoleapp.repositories;

import com.lab1.springbootconsoleapp.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
