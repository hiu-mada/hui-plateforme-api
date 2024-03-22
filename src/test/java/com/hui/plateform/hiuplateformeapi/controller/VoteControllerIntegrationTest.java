package com.hui.plateform.hiuplateformeapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hui.plateform.hiuplateformeapi.entity.Vote;
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
public class VoteControllerIntegrationTest{

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAllVote() throws Exception {
        mockMvc.perform(get("/vote"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void createVote() throws Exception {
        Vote vote = new Vote();
        vote.setIdChallenger("1");
        vote.setIdUser("1");

        mockMvc.perform(post("/vote")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(vote)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void getVoteById() throws Exception {
        String voteId = "1";

        mockMvc.perform(get("/vote/{id}", voteId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void deleteVoteById() throws Exception {
        String voteId = "1";

        mockMvc.perform(delete("/vote/{id}", voteId))
                .andExpect(status().isOk());
    }

    @Test
    public void countVotesByIdTeam() throws Exception {
        mockMvc.perform(get("/vote/count-by-team"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void countVoteOfTeam() throws Exception {
        String teamId = "1";

        mockMvc.perform(get("/vote/count-by-team/{id}", teamId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
