package com.hui.plateform.hiuplateformeapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "response_table")
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "response")
    private String response;

    @Column(name = "commentary")
    private String commentary;

    @Column(name = "id_challenger_team")
    private String idChallengerTeam;

    @Column(name = "id_subject")
    private String idSubject;
}
