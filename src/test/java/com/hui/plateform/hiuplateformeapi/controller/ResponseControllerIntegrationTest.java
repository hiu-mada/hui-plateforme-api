package com.hui.plateform.hiuplateformeapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hui.plateform.hiuplateformeapi.entity.Response;
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
public class ResponseControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAllResponse() throws Exception {
        mockMvc.perform(get("/response"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void createResponse() throws Exception {
        Response response = new Response();
        response.setResponse("Test Response");
        response.setCommentary("Commentary for Test Response");
        response.setIdChallengerTeam("1");
        response.setIdSubject("1");

        mockMvc.perform(post("/response")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(response)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void getResponseById() throws Exception {
        String responseId = "1";

        mockMvc.perform(get("/response/{id}", responseId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void updateResponse() throws Exception {
        String responseId = "1";

        Response updatedResponse = new Response();
        updatedResponse.setResponse("Updated Response");
        updatedResponse.setCommentary("Updated Commentary for Response");
        updatedResponse.setIdChallengerTeam("1");
        updatedResponse.setIdSubject("1");

        mockMvc.perform(put("/response/{id}", responseId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedResponse)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void deleteResponseById() throws Exception {
        String responseId = "1";

        mockMvc.perform(delete("/response/{id}", responseId))
                .andExpect(status().isOk());
    }
}
