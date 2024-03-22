package com.hui.plateform.hiuplateformeapi.controller;


import com.hui.plateform.hiuplateformeapi.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String email;
    private String username;
    private String password;
    private String  profilePicture;
    private Role role;
}
