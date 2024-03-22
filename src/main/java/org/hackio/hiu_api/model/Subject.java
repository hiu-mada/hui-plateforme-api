package org.hackio.hiu_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "subject")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private float maxScore;

  @ManyToOne
  @JoinColumn(name = "challenger_team_id")
  private ChallengerTeam challengerTeam;

  @OneToMany(mappedBy = "subject")
  private Set<Response> responses;
}
