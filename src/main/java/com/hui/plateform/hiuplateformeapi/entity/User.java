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
@Table(name = "user_table")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = IDENTITY)
    private String id;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "profile_picture")
    private String profile_picture;
}
