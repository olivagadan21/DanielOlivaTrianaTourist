package com.salesianostriana.dam.DanielOlivaTrianaTourist.model;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.validacion.anotaciones.UniqueNameRoute;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.validacion.anotaciones.UniquePOI;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.Valid;
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

    private String name;

    @ManyToMany
    private List<POI> steps = new ArrayList<>();

    public void addPoi(@Valid POI poi) {
        steps.add(poi);
    }

    public void removePoi(@Valid POI poi) {
        steps.remove(poi);
    }

}
