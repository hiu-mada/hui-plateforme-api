package com.hui.plateform.hiuplateformeapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hui.plateform.hiuplateformeapi.entity.User;
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
public class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAllUser() throws Exception {
        mockMvc.perform(get("/user"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void getUserById() throws Exception {
        String userId = "1";

        mockMvc.perform(get("/user/{id}", userId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void createUser() throws Exception {
        User user = new User();
        user.setEmail("test@example.com");
        user.setUsername("testuser");
        user.setPassword("testpassword");
        user.setProfilePicture("profile.jpg");
        user.setIdChallenger("1");

        mockMvc.perform(post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void updateUser() throws Exception {
        String userId = "1";

        User updatedUser = new User();
        updatedUser.setEmail("updated@example.com");
        updatedUser.setUsername("updateduser");
        updatedUser.setPassword("updatedpassword");
        updatedUser.setProfilePicture("updated_profile.jpg");
        updatedUser.setIdChallenger("2");

        mockMvc.perform(put("/user/{id}", userId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedUser)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void deleteUserById() throws Exception {
        String userId = "1";

        mockMvc.perform(delete("/user/{id}", userId))
                .andExpect(status().isOk());
    }
}
