package com.lab1.springbootconsoleapp.repositories;

import com.lab1.springbootconsoleapp.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
