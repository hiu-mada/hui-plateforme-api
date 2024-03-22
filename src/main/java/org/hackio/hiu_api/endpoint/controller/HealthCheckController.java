package org.hackio.hiu_api.endpoint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
  @GetMapping("/ping")
  public String healthCheck() {
    String pong = "pong";
    return pong;
  }
}
