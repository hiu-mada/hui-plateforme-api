package org.hackio.hiu_api.repository;

import org.hackio.hiu_api.model.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
  Optional<RefreshToken> findByToken(String Token);

  void deleteByToken(String token);
}
