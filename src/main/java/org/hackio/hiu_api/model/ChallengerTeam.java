package org.hackio.hiu_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "team")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChallengerTeam {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String slogan;

  @ManyToOne
  @JoinColumn(name = "university_id")
  private University university;

  @ManyToOne
  @JoinColumn(name = "discipline_id")
  private Discipline discipline;

  @OneToMany(mappedBy = "challengerTeam")
  private Set<Subject> subjects;

  @OneToMany(mappedBy = "challengerTeam")
  private Set<Vote> votes;
}
