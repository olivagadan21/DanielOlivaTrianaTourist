package com.salesianostriana.dam.DanielOlivaTrianaTourist.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class Category {

    @Id @GeneratedValue
    private Long id;

    @NotBlank
    // @UniqueNameCategory
    private String name;

}
