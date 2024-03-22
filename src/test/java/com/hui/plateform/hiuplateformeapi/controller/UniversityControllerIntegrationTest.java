package com.hui.plateform.hiuplateformeapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hui.plateform.hiuplateformeapi.entity.University;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UniversityControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAllUniversity() throws Exception {
        mockMvc.perform(get("/university"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void getUniversityById() throws Exception {
        String universityId = "1";

        mockMvc.perform(get("/university/{id}", universityId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void createUniversity() throws Exception {
        University university = new University();
        university.setName("Test University");
        university.setDescription("Description of Test University");

        mockMvc.perform(post("/university")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(university)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void updateUniversity() throws Exception {
        String universityId = "1";

        University updatedUniversity = new University();
        updatedUniversity.setName("Updated University Name");
        updatedUniversity.setDescription("Updated Description of University");

        mockMvc.perform(put("/university/{id}", universityId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedUniversity)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void deleteUniversityById() throws Exception {
        String universityId = "1";

        mockMvc.perform(delete("/university/{id}", universityId))
                .andExpect(status().isOk());
    }
}
