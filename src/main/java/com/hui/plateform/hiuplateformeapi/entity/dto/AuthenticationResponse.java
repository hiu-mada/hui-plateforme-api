package com.hui.plateform.hiuplateformeapi.entity.dto;

import lombok.*;


@Getter
public class AuthenticationResponse {
    private final String token;

    public AuthenticationResponse(String token) {
        this.token = token;
    }

}
