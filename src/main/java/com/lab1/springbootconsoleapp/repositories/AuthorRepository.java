package com.lab1.springbootconsoleapp.repositories;

import com.lab1.springbootconsoleapp.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
