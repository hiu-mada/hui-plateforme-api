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
@Table(name = "discipline_table")
public class Discipline {
     @Id
     @Column(name = "id")
     @GeneratedValue(strategy = IDENTITY)
     private String id;

     @Column(name = "name")
     private String name;

     @Column(name = "description")
     private String description;
}
