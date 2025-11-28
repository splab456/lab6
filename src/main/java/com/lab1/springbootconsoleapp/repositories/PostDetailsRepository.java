package com.lab1.springbootconsoleapp.repositories;

import com.lab1.springbootconsoleapp.models.PostDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDetailsRepository extends JpaRepository<PostDetails, Long> {
}
