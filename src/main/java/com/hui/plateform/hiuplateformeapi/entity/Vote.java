package com.hui.plateform.hiuplateformeapi.entity;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "vote_table")
public class Vote {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private String id;

    @Column(name = "id_challenger")
    private String idChallenger;

    @Column(name = "id_user")
    private String idUser;
}
