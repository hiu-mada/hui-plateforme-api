package org.hackio.hiu_api.service;


import lombok.AllArgsConstructor;
import org.hackio.hiu_api.execption.HackioException;
import org.hackio.hiu_api.model.RefreshToken;
import org.hackio.hiu_api.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class RefreshTokenService {

  private final RefreshTokenRepository refreshTokenRepository;
  public RefreshToken generateRefreshToken(){
    RefreshToken refreshToken = new RefreshToken();
    refreshToken.setToken(UUID.randomUUID().toString());
    refreshToken.setCreatedDate(Instant.now());

    return refreshTokenRepository.save(refreshToken);
  }

  void validateRefreshToken(String token){
    refreshTokenRepository.findByToken(token)
      .orElseThrow(() -> new HackioException("invalid refresh token"));

  }

  public void deleteRefreshToken(String token){
    refreshTokenRepository.deleteByToken(token);
  }
}

