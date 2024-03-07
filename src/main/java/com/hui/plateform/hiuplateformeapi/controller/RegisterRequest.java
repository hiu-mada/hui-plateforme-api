package com.hui.plateform.hiuplateformeapi.controller;


import lombok.Data;

@Data
public class RegisterRequest {
    private String email;
    private String username;
    private String password;
    private String  profile_picture;
}
