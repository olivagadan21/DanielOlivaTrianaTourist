package com.salesianostriana.dam.DanielOlivaTrianaTourist.dto.route;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.validacion.anotaciones.UniqueNameRoute;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRouteDto {

    private Long id;

    @UniqueNameRoute(message = "{unique.name}")
    private String name;

}
