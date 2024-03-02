package com.hui.plateform.hiuplateformeapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "challenger_team_table")
public class ChallengerTeam {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "slogant")
    private String slogant;

    @Column(name = "id_university")
    private String idUniversity;

    @Column(name= "id_discipline")
    private String idDiscipline;
}
