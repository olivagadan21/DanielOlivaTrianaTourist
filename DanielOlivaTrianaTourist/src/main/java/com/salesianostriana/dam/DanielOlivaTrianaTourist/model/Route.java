package com.salesianostriana.dam.DanielOlivaTrianaTourist.model;

// import com.salesianostriana.dam.DanielOlivaTrianaTourist.validacion.anotaciones.UniqueNameRoute;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class Route {

    @Id @GeneratedValue
    private Long id;

    // @UniqueNameRoute
    private String name;

    @ManyToMany
    private List<POI> steps = new ArrayList<>();

}
