package org.hackio.hiu_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "response")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String response;
  private String commentary;

  @ManyToOne
  @JoinColumn(name = "subject_id")
  private Subject subject;
}
