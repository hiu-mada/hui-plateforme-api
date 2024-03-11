package com.hui.plateform.hiuplateformeapi.controller;

import lombok.*;


@Getter
public class AuthenticationResponse {
    private final String token;

    public AuthenticationResponse(String token) {
        this.token = token;
    }

}
