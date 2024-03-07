package com.hui.plateform.hiuplateformeapi.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "university_table")
public class University {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
}
