package com.hui.plateform.hiuplateformeapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hui.plateform.hiuplateformeapi.entity.Discipline;
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
public class DisciplineControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAllDisciplines() throws Exception {
        mockMvc.perform(get("/disciplines"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void createDiscipline() throws Exception {
        Discipline discipline = new Discipline();
        discipline.setName("Test Discipline");
        discipline.setDescription("Description of Test Discipline");

        mockMvc.perform(post("/disciplines")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(discipline)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void getDisciplineById() throws Exception {
        String disciplineId = "1";

        mockMvc.perform(get("/disciplines/{id}", disciplineId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void updateDiscipline() throws Exception {
        String disciplineId = "1";

        Discipline updatedDiscipline = new Discipline();
        updatedDiscipline.setName("Updated Discipline Name");
        updatedDiscipline.setDescription("Updated Description of Discipline");

        mockMvc.perform(put("/disciplines/{id}", disciplineId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedDiscipline)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void deleteDisciplineById() throws Exception {
        String disciplineId = "1";

        mockMvc.perform(delete("/disciplines/{id}", disciplineId))
                .andExpect(status().isOk());
    }
}
