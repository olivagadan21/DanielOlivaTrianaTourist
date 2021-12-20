package com.salesianostriana.dam.DanielOlivaTrianaTourist.services;

import com.salesianostriana.dam.DanielOlivaTrianaTourist.dto.route.CreateRouteDto;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.dto.route.RouteDtoConverter;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.errores.excepciones.ExistingPOIRoute;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.errores.excepciones.ListEntityNotFoundException;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.errores.excepciones.SingleEntityNotFoundException;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.POI;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.model.Route;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.repos.POIRepository;
import com.salesianostriana.dam.DanielOlivaTrianaTourist.repos.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final POIRepository poiRepository;
    private final RouteRepository repositorio;
    private final RouteDtoConverter routeDtoConverter;

    public List<Route> findAll() {
        List<Route> result = repositorio.findAll();

        if (result.isEmpty()) {
            throw new ListEntityNotFoundException(Route.class);
        } else {
            return result;
        }
    }


    public Route findById(Long id) {
        return repositorio.findById(id).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Route.class));
    }

    public Route save(CreateRouteDto routeDto) {
        Route route = routeDtoConverter.createRouteDtoToRoute(routeDto);
        repositorio.save(route);
        return route;
    }

    public Optional<Route> edit(Route route, Long id){
        return repositorio.findById(id).map(r -> {
            r.setName(route.getName());
            return repositorio.save(r);
        });
    }

    public void deleteById(Long id){
        if (repositorio.findById(id) != null){
            repositorio.deleteById(id);
        } else {
            throw new SingleEntityNotFoundException(id.toString(), Route.class);
        }
    }

    public Route addPoiToRoute (Long id1, Long id2) {
        if (poiRepository.findById(id2).isEmpty()){
            throw new ExistingPOIRoute(POI.class);
        }

        repositorio.getById(id1).getSteps().forEach(
                poi -> {
                    if (poi.getId().equals(id2)){
                        throw new ExistingPOIRoute(POI.class);
                    }
                }
        );
        repositorio.getById(id1).addPoi(poiRepository.getById(id2));
        return repositorio.save(repositorio.getById(id1));


    }

    public void removePoiToRoute (Long id1, Long id2) {

        repositorio.getById(id1).removePoi(poiRepository.getById(id2));

    }

}
