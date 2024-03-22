package org.hackio.hiu_api.endpoint.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RefreshTokenRequest {
  @NotBlank
  private String refreshToken;
  private String username;
}
