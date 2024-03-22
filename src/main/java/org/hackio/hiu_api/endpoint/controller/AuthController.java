package org.hackio.hiu_api.endpoint.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.hackio.hiu_api.endpoint.dto.AuthenticationResponse;
import org.hackio.hiu_api.endpoint.dto.LoginRequest;
import org.hackio.hiu_api.endpoint.dto.RefreshTokenRequest;
import org.hackio.hiu_api.endpoint.dto.RegisterRequest;
import org.hackio.hiu_api.service.AuthService;
import org.hackio.hiu_api.service.RefreshTokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
  private final AuthService authService;
  private final RefreshTokenService refreshTokenService;

  @PostMapping("/signup")
  public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest){
    authService.signup(registerRequest);
    return new ResponseEntity<>("User Registration Successful", HttpStatus.OK);
  }

  @PostMapping("/login")
  public AuthenticationResponse login (@RequestBody LoginRequest loginRequest){
    return authService.login(loginRequest);
  }

  @PostMapping("/refresh/token")
  public AuthenticationResponse refreshToken (
    @Valid @RequestBody RefreshTokenRequest refreshTokenRequest){
    return authService.refreshToken(refreshTokenRequest);
  }

  @PostMapping("/logout")
  public ResponseEntity<String> logout(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
    refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
    return ResponseEntity.status(OK).body("Refresh Token Deleted Successfully!!");
  }
}

