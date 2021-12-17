package com.salesianostriana.dam.DanielOlivaTrianaTourist.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class POI {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private String location;

    @Lob
    private String description;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;

    private String coverPhoto;

    private String photo2;

    private String photo3;

}
