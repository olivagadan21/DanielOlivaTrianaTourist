package com.salesianostriana.dam.DanielOlivaTrianaTourist.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

}
