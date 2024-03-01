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
     @GeneratedValue(strategy = IDENTITY)
     private String id;

     private String name;
     private String description;
}
