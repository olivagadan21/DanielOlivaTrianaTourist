package com.salesianostriana.dam.DanielOlivaTrianaTourist.dto.route;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.Route;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component@RequiredArgsConstructor
public class RouteDtoConverter {

    public Route createRouteDtoToRoute (CreateRouteDto createRouteDto) {
        return Route.builder()
                .name(createRouteDto.getName())
                .build();
    }

}
