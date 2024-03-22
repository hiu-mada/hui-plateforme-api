package org.hackio.hiu_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "university")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class University {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String description;

  @OneToMany(mappedBy = "university")
  private Set<ChallengerTeam> challengerTeams;

}

