package com.hui.plateform.hiuplateformeapi.controller;


import com.hui.plateform.hiuplateformeapi.Service.AuthenticationService;
import com.hui.plateform.hiuplateformeapi.entity.User;
import com.hui.plateform.hiuplateformeapi.entity.dto.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody User request
    ){

            return ResponseEntity.ok(service.register(request));
      
    }

    @PostMapping("/authentication")
    public ResponseEntity<AuthenticationResponse> authentication(
            @RequestBody User request){
       return  ResponseEntity.ok(service.authenticate(request));
    }
}
