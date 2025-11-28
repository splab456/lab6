package com.lab1.springbootconsoleapp.controllers;

import com.lab1.springbootconsoleapp.models.Post;
import com.lab1.springbootconsoleapp.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BlogController {

    private final PostRepository postRepository;

    public BlogController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/blog";
    }

    @GetMapping("/blog")
    public String blogMain(Model model) {
        List<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable Long id, Model model) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));
        model.addAttribute("post", post);
        return "blog-view";
    }
}
