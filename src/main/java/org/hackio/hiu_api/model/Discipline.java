package org.hackio.hiu_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "discipline")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Discipline {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;
  public String name;
  public String description;

  @OneToMany(mappedBy = "discipline")
  private Set<ChallengerTeam> challengerTeams;
}
