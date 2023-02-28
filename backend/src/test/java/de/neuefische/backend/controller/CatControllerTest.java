package de.neuefische.backend.controller;

import de.neuefische.backend.model.Cat;
import de.neuefische.backend.repository.CatRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CatControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private CatRepository repository;

    @Test
    void allCats() throws Exception {

        mockMvc.perform(get("/api/cats"))
                .andExpect(status().isOk());

    }

    @Test
    void getById() throws Exception {
        repository.save(new Cat("1", "name", "breed", true, LocalDateTime.now()));

        mockMvc.perform(get("/api/cats/1"))
                .andExpect(status().isOk());
    }
}