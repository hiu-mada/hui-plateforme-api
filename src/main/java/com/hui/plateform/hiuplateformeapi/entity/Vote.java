package com.hui.plateform.hiuplateformeapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "vote_table")
public class Vote {

    @Column(name = "id_challenger")
    private String idChallenger;

    @Column(name = "id_user")
    private String idUser;
}
