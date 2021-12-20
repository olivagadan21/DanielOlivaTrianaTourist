package com.salesianostriana.dam.DanielOlivaTrianaTourist.model;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.validacion.anotaciones.ExistingCategory;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.validacion.anotaciones.UniqueURL;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class POI {

    @Id @GeneratedValue
    private Long id;

    @NotBlank(message = "{not.blank}")
    private String name;

    // @FormatLocation
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
