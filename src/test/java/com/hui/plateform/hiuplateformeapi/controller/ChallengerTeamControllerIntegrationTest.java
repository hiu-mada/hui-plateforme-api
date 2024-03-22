package com.hui.plateform.hiuplateformeapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hui.plateform.hiuplateformeapi.entity.ChallengerTeam;
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
public class ChallengerTeamControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAllTeam() throws Exception {
        mockMvc.perform(get("/team"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void createTeam() throws Exception {
        ChallengerTeam team = new ChallengerTeam();
        team.setName("Test Team");
        team.setSlogant("Slogan of Test Team");

        mockMvc.perform(post("/team")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(team)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void getTeamById() throws Exception {
        String teamId = "1";

        mockMvc.perform(get("/team/{id}", teamId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void updateTeam() throws Exception {
        String teamId = "1";

        ChallengerTeam updatedTeam = new ChallengerTeam();
        updatedTeam.setName("Updated Team Name");
        updatedTeam.setSlogant("Updated Slogan of Team");

        mockMvc.perform(put("/team/{id}", teamId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedTeam)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void deleteTeamById() throws Exception {
        String teamId = "1";

        mockMvc.perform(delete("/team/{id}", teamId))
                .andExpect(status().isOk());
    }
}
