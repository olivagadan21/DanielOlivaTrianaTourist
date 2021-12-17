package com.salesianostriana.dam.DanielOlivaTrianaTourist.services;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.dto.CreateCategoryDto;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.dto.CreateRouteDto;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.Category;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.Route;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.repos.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository repositorio;


    /* public List<Route> findAll() {
        List<Route> result = repositorio.findAll();

        if (result.isEmpty()) {
            throw new ListEntityNotFoundException(Route.class);
        } else {
            return result;
        }
    }

     */


    /* public Route findById(Long id) {
        return repositorio.findById(id).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Route.class));
    }
     */


    public Route save(CreateRouteDto routeDto) {
        return repositorio.save(Route.builder()
                .name(routeDto.getName())
                .build());
    }

    public Optional<Route> edit(Route route, Long id){
        return repositorio.findById(id).map(r -> {
            r.setName(route.getName());
            return repositorio.save(r);
        });
    }

    public void deleteById(Long id){
        repositorio.deleteById(id);
    }

}
