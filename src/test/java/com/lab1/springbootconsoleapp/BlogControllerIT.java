package com.lab1.springbootconsoleapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class BlogControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void blogPageReturnsOk() throws Exception {
        mockMvc.perform(get("/blog"))
                .andExpect(status().isOk())
                .andExpect(view().name("blog-main"))
                .andExpect(model().attributeExists("posts"));
    }
}
