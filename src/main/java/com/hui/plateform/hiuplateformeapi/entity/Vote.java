package com.hui.plateform.hiuplateformeapi.entity;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "vote_table")
public class Vote {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "id_challenger")
    private String idChallenger;

    @Column(name = "id_user")
    private String idUser;
}
